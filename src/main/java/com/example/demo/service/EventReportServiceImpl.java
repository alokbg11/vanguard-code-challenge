package com.example.demo.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EventRepository;
import com.example.demo.model.Event;
import com.example.demo.utility.DemoUtility;

@Service
public class EventReportServiceImpl implements EventReportService {

	@Value("${events.directory.path}")
	private String dirPath;

	@Autowired
	private DemoUtility demoUtility;

	@Autowired
	private EventRepository eventRepository;

	@Override
	public List<Event> getFilteredEvents() {

		List<Event> allEvents = eventRepository.findAll();
		
		if (allEvents == null || allEvents.isEmpty()) {
			this.addEvents();
			allEvents = eventRepository.findAll();
		}

		List<Event> filteredEvents = this.filterEvents(allEvents);

		return filteredEvents;
	}

	@Override
	public void addEvents() {

		List<Event> events = new ArrayList<Event>();

		File directory = new File(dirPath);
		File[] files = directory.listFiles();

		Arrays.stream(files).forEach((file) -> {
			String buyerParty = demoUtility.parseXml("//buyerPartyReference/@href", file);
			String sellerParty = demoUtility.parseXml("//sellerPartyReference/@href", file);
			double premiumAmount = Double.valueOf(demoUtility.parseXml("//paymentAmount/amount", file));
			String premiumCurrency = demoUtility.parseXml("//paymentAmount/currency", file);

			events.add(new Event(buyerParty, sellerParty, premiumAmount, premiumCurrency));
		});
		
		eventRepository.saveAll(events);
	}

	private List<Event> filterEvents(List<Event> events) {
		return events.stream()
				.filter(event -> (event.getSellerParty().equals("EMU_BANK") && event.getPremiumCurrency().equals("AUD")
						|| event.getSellerParty().equals("BISON_BANK") && event.getPremiumCurrency().equals("USD")))
				.filter(event -> !demoUtility.isAnagram(event.getBuyerParty(), event.getSellerParty()))
				.collect(Collectors.toList());
	}

}

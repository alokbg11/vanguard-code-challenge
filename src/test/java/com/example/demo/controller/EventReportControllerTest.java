package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.example.demo.model.Event;
import com.example.demo.service.EventReportServiceImpl;

@SpringJUnitConfig
@SpringBootTest
public class EventReportControllerTest {

	@Mock
	private EventReportServiceImpl eventReportService;

	@BeforeAll
	public static void setUp() {

	}

	@Test
	public void testGetFilteredEvents() {
		Event e1 = new Event("EMU_BANK", "LEFT_BANK", 100.00, "AUD");
		Event e2 = new Event("LEFT_BANK", "EMU_BANK", 200.00, "USD");

		List<Event> le = new ArrayList<Event>();
		le.add(e1);
		le.add(e2);

		Mockito.when(eventReportService.getFilteredEvents()).thenReturn(le);
		List<Event> filteredEvents = eventReportService.getFilteredEvents();
		assertEquals(le, filteredEvents);
	}

}

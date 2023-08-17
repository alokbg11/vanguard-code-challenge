package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Event;
import com.example.demo.service.EventReportService;

@RestController
public class EventReportController {

	@Autowired
	EventReportService eventReportService;

	@GetMapping(value = "/reports", produces = { "application/JSON" })
	public List<Event> getFilteredEvents() {
		List<Event> filteredEvents = eventReportService.getFilteredEvents();
		return filteredEvents;
	}

}

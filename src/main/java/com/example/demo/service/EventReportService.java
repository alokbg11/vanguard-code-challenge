package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Event;

public interface EventReportService {
	
	public List<Event> getFilteredEvents();
	public void addEvents();

}

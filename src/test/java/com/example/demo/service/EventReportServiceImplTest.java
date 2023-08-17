package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.demo.dao.EventRepository;
import com.example.demo.model.Event;
import com.example.demo.utility.DemoUtility;

public class EventReportServiceImplTest {

    @InjectMocks
    private EventReportServiceImpl eventReportService;

    @Mock
    private EventRepository eventRepository;

    @Mock
    private DemoUtility demoUtility;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetFilteredEvents() {
        List<Event> allEvents = new ArrayList<>();
        allEvents.add(new Event("EMU_BANK", "BISON_BANK", 100.00, "USD"));
        allEvents.add(new Event("LEFT_BANK", "EMU_BANK", 200.00, "AUD"));

        when(eventRepository.findAll()).thenReturn(allEvents);
        when(demoUtility.isAnagram(anyString(), anyString())).thenReturn(false);

        List<Event> filteredEvents = eventReportService.getFilteredEvents();

        assertEquals(2, filteredEvents.size());
    }

    @Test
    public void testAddEvents() {
        //test case here
    }
}


package com.example.demo.utility;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
@SpringBootTest
public class DemoUtilityTest {

	@InjectMocks
	private DemoUtility demoUtility;

	@BeforeAll
	public static void setUp() {

	}

	@Test
	public void testParseXml(){
		//test code here
	}

	@Test
	public void testIsAnagram() {
		//test code here
	}

}

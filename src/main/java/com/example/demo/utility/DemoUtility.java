package com.example.demo.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

@Component
public class DemoUtility {

	public String parseXml(String expression, File file) {
		FileInputStream is;
		String value = null;
		try {
			is = new FileInputStream(file);
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			Document xmlDocument = builder.parse(is);
			XPath xpath = XPathFactory.newInstance().newXPath();
			value = xpath.compile(expression).evaluate(xmlDocument);
		} catch (ParserConfigurationException | SAXException | IOException | XPathExpressionException e) {
			e.printStackTrace();
		}
		return value;
	}

	public boolean isAnagram(String buyerParty, String sellerParty) {
		if (buyerParty == null || sellerParty == null || buyerParty.length() != sellerParty.length()) {
			return false;
		}
		char[] char1 = buyerParty.toCharArray();
		char[] char2 = sellerParty.toCharArray();

		Arrays.sort(char1);
		Arrays.sort(char2);

		return Arrays.equals(char1, char2);
	}

}

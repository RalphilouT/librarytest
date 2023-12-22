package com.example.librarywebtest;

import com.example.librarywebtest.utilities.CommonUtilities;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class LibrarywebtestApplicationTests {
	CommonUtilities commonUtilities = new CommonUtilities();
	Properties properties = new Properties();

	@Test
	void contextLoads() {

	}
	@Test
	public void testUtilitiesUrl() throws IOException {
		properties = commonUtilities.getPropBase();

		assertEquals(properties.getProperty("baseUrl"),"http://localhost:3000/");

	}

	@Test
	void testUtilityComparison() throws IOException {

		String[] comparison = {};
		String[] actualHeader = {"Title","ISBN","Description","Suggestion"};
		comparison = commonUtilities.getCompareProperties("compareHeader");
		for(int i = 0; i < comparison.length; i++){
			assertEquals(comparison[i], actualHeader[i]);
		}
	}
}

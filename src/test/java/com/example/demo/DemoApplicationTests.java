package com.example.demo;

import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRStyledTextParser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
		JRStyledTextParser jr = JRStyledTextParser.getInstance();
	}

}

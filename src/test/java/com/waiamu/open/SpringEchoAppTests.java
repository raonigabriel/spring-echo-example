package com.waiamu.open;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringEchoApp.class)
@WebIntegrationTest
public class SpringEchoAppTests {

	@Test
	public void contextLoads() {
	}

}

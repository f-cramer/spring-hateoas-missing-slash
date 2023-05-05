package com.example.demo;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class HateoasSlashExampleApplicationTests implements WithAssertions {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void testSlashAfterContextPath() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/hello")
						.header("X-Forwarded-Host", "localhost")
						.header("X-Forwarded-Port", "8080")
						.header("X-Forwarded-Prefix", "/prefix")
				)
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.content().string("http://localhost:8080/prefix/hello"));
	}
}

package com.example.project3;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class Project3ApplicationTests {

	Calculator c = new Calculator();

	@Test
	void contextLoads() {

	}

	@Test
	void testSum(){
		int expectedOutput = 7;
		int actutalOutput = c.doSum(3,3);
		assertThat(actutalOutput).isEqualTo(expectedOutput);
	}

}

package com.ai.SpringAiDemo;

import com.ai.SpringAiDemo.Services.OpenAiServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringAiDemoApplication {
	private final OpenAiServiceImpl openAiService;
	public static void main(String[] args) {

		SpringApplication.run(SpringAiDemoApplication.class, args); //implements CommandLineRunner
	}

//	@Override
//	public void run(String... args) throws Exception {
//		openAiService.embeddingExample();
//	}
}

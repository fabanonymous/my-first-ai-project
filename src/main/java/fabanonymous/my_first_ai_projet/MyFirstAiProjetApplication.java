package fabanonymous.my_first_ai_projet;

import fabanonymous.my_first_ai_projet.functions.WeatherConfigProperties;
import org.springframework.ai.chat.client.ChatClient;
//import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * See Dan Vega's GitHub repo at https://github.com/danvega/spring-into-ai
 *
 * See Dan Vega - Using Multiple LLMs in Java with Spring AI,
 * at https://www.youtube.com/watch?v=bK1MTlEDQvk&t=641s
 */
@SpringBootApplication
@EnableConfigurationProperties(WeatherConfigProperties.class)
public class MyFirstAiProjetApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyFirstAiProjetApplication.class, args);
	}


	@Bean
	public ChatClient openAiChatClient(OpenAiChatModel chatModel) {
		return ChatClient.create(chatModel);
	}

	/*
	@Bean
	public ChatClient ollamaChatClient(OllamaChatModel chatModel) {
		return ChatClient.create(chatModel);
	}
	 */
}

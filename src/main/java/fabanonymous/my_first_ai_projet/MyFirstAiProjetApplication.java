package fabanonymous.my_first_ai_projet;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

// https://www.youtube.com/watch?v=TWlBGA3x3cQ&t=125s

@SpringBootApplication
public class MyFirstAiProjetApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyFirstAiProjetApplication.class, args);
	}


	@Bean
	public ChatClient openAiChatClient(OpenAiChatModel chatModel) {
		return ChatClient.create(chatModel);
	}

	@Bean
	public ChatClient ollamaChatClient(OllamaChatModel chatModel) {
		return ChatClient.create(chatModel);
	}
}

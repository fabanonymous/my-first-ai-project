package fabanonymous.my_first_ai_projet;

import fabanonymous.my_first_ai_projet.functions.WeatherConfigProperties;
import fabanonymous.my_first_ai_projet.rag_with_pgvector_with_pdf_files.Rag2IngestionService;
import org.springframework.ai.chat.client.ChatClient;
//import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * See Dan Vega's videos on Youtube and its Github repos:
 *
 * - Java + RAG: Create an AI-Powered Financial Advisor using Spring AI
 * 		- Youtube: https://www.youtube.com/watch?v=6Pgmr7xMjiY
 *		- Github: https://github.com/danvega/java-rag
 *
 * - Getting started with (Retrieval Augmented Generation) RAG in Java & Spring AI:
 * 		- Youtube: https://www.youtube.com/watch?v=4-rG2qsTrAs
 * 		- Github: https://github.com/danvega/spring-into-ai
 *
 * Using Multiple LLMs in Java with Spring AI
 * 		- Youtube: https://www.youtube.com/watch?v=bK1MTlEDQvk
 * 		- Github: https://github.com/danvega/multiple-llms
 */
@SpringBootApplication
@EnableConfigurationProperties(WeatherConfigProperties.class)
public class MyFirstAiProjetApplication implements CommandLineRunner {

	@Autowired
	Rag2IngestionService rag2IngestionService;

	public static void main(String[] args) {
		SpringApplication.run(MyFirstAiProjetApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		rag2IngestionService.ingest();
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

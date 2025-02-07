package fabanonymous.my_first_ai_projet.rag_with_pgvector_with_pdf_files;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.QuestionAnswerAdvisor;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * See Dan Vega on YouTube: Java + RAG: Create an AI-Powered Financial Advisor using Spring AI,
 * at https://www.youtube.com/watch?v=6Pgmr7xMjiY
 * Github repo: https://github.com/danvega/java-rag
 */
@RestController
@RequestMapping("/rag2")
public class Rag2RestController {

    private final ChatClient chatClient;

    public Rag2RestController(ChatClient.Builder builder, VectorStore vectorStore) {
        this.chatClient = builder
                .defaultAdvisors(new QuestionAnswerAdvisor(vectorStore))
                .build();
    }

    // http :8080/rag2/faq message=="How did the Federal Reserve's recent interest rate cut impact various asset classes according to the analysis"
    @GetMapping("/faq")
    public String faq(@RequestParam(value = "message", defaultValue = "How did the Federal Reserve's recent interest rate cut impact various asset classes according to the analysis") String message) {
        return chatClient.prompt()
                .user(message)
                .call()
                .content();
    }
}

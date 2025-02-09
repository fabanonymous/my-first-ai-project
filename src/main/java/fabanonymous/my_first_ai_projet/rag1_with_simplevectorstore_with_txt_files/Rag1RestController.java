package fabanonymous.my_first_ai_projet.rag1_with_simplevectorstore_with_txt_files;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * See Dan Vega on YouTube:
 * - Java + RAG: Create an AI-Powered Financial Advisor using Spring AI: https://www.youtube.com/watch?v=6Pgmr7xMjiY
 * - Getting started with (Retrieval Augmented Generation) RAG in Java & Spring AI: https://www.youtube.com/watch?v=4-rG2qsTrAs&t=3s
 *
 * The class below is based on the Getting started with RAG in Java & Spring AI at https://www.youtube.com/watch?v=4-rG2qsTrAs&t=3s
 */
@RestController
@RequestMapping("/rag1")
public class Rag1RestController {

    private final ChatClient chatClient;

    public Rag1RestController(@Qualifier("ChatClientForRag1")ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    // http :8080/rag1/faq message=="How many athletes compete in the Olympic Games Paris 2024"
    @GetMapping("/faq")
    public String faq(@RequestParam(value = "message", defaultValue = "How many athletes compete in the Olympic Games Paris 2024") String message) {
        return chatClient.prompt()
                .user(message)
                .call()
                .content();
    }

}

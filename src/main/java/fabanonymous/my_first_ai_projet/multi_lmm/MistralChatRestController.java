package fabanonymous.my_first_ai_projet.multi_lmm;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * See Dan Vega - Using Multiple LLMs in Java with Spring AI,
 * at https://www.youtube.com/watch?v=bK1MTlEDQvk&t=641s
 * Example of how to run Ollama with DeepSeek: ollama run deepseek-r1:1.5b
 */
@RestController
public class MistralChatRestController {

    private final ChatClient chatClient;

    public MistralChatRestController(@Qualifier("ChatClientForMistral") ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    //http :8080/mistral
    @GetMapping("/mistral")
    public String mistral() {
        return chatClient.prompt()
                .user("How many r's are in Strawberry")
                .call()
                .content();
    }

    //http --stream :8080/mistral-stream
    @GetMapping("/mistral-stream")
    public Flux<String> mistralStream() {
        return chatClient.prompt()
                .user("How many r's are in Strawberry")
                .stream()
                .content();
    }
}

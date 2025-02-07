package fabanonymous.my_first_ai_projet.multi_lmm;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * See Dan Vega - Using Multiple LLMs in Java with Spring AI,
 * at https://www.youtube.com/watch?v=bK1MTlEDQvk&t=641s
 */
@RestController
public class OllamaChatRestController {

    private final ChatClient chatClient;

    public OllamaChatRestController(@Qualifier("ollamaChatClient") ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/ollama")
    public Flux<String> ollama() {
        return chatClient.prompt()
                .user("Can you give an example of a leet style coding problem and answer it in Java")
                .stream()
                .content();
    }
}

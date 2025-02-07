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
public class OllamaChatRestController {

    /*
    private final ChatClient chatClient;

    //public OllamaChatRestController(@Qualifier("openAiChatClient") ChatClient chatClient) {
    public OllamaChatRestController(@Qualifier("ollamaChatClient") ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    //http --stream :8080/ollama-stream
    @GetMapping("/ollama-stream")
    public Flux<String> ollama() {
        return chatClient.prompt()
                .user("Can you give an example of a leet style coding problem and answer it in Java")
                .stream()
                .content();
    }
     */
}

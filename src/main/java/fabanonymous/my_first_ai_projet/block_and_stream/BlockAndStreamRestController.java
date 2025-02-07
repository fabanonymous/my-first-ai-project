package fabanonymous.my_first_ai_projet.block_and_stream;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * See Dan Vega - Using Multiple LLMs in Java with Spring AI,
 * at https://www.youtube.com/watch?v=bK1MTlEDQvk&t=641s
 */
@RestController
@RequestMapping("/bs")
public class BlockAndStreamRestController {

    private final ChatClient chatClient;

    public BlockAndStreamRestController(@Qualifier("openAiChatClient") ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    //http :8080/bs/blocking
    @GetMapping("/blocking")
    public String blocking() {
        return chatClient.prompt()
                .user("How many r's are in Strawberry")
                .call()
                .content();
    }

    //http --stream :8080/bs/stream
    @GetMapping("/stream")
    public Flux<String> deepseekStream() {
        return chatClient.prompt()
                .user("How many r's are in Strawberry")
                .stream()
                .content();
    }
}

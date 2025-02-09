package fabanonymous.my_first_ai_projet.functions;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * See Dan Vega - Spring AI Functions - How to register custom Java functions with the Chat Client,
 * at https://www.youtube.com/watch?v=n7IvE1VSbvI&t=580s
 */
@RestController
@RequestMapping("/functions")
public class FunctionsRestController {

    private final ChatClient chatClient;

    public FunctionsRestController(@Qualifier("ChatClientForFunctions")ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    // http :8080/functions/cities message=="What is the weather currently at Paris, France ?"
    @GetMapping("/cities")
    public String cityFaq(@RequestParam String message) {
        return chatClient.prompt()
                .user(message)
                .call()
                .content();
    }
}

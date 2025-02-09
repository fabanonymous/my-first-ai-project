package fabanonymous.my_first_ai_projet.multi_lmm;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MistralConfiguration {

    @Bean(name="ChatClientForMistral")
    public ChatClient chatClient(ChatClient.Builder builder) {
        return builder
                .build();
    }
}

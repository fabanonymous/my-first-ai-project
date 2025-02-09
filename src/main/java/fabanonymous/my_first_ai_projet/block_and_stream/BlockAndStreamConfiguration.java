package fabanonymous.my_first_ai_projet.block_and_stream;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.mistralai.MistralAiChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BlockAndStreamConfiguration {

    @Bean(name="ChatClientForBlockAndStream")
    public ChatClient chatClient(MistralAiChatModel chatModel) {
        return ChatClient.builder(chatModel)
                .build();
    }
}

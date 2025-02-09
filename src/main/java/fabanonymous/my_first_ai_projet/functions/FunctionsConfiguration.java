package fabanonymous.my_first_ai_projet.functions;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import java.util.function.Function;

@Configuration
public class FunctionsConfiguration {

    private final WeatherConfigProperties props;

    public FunctionsConfiguration(WeatherConfigProperties props) {
        this.props = props;
    }

    @Bean
    @Description("Get the current weather conditions for the given city.")
    public Function<WeatherService.Request,WeatherService.Response> currentWeatherFunction() {
        return new WeatherService(props);
    }

    @Bean(name="ChatClientForFunctions")
    public ChatClient openAiChatClient(OpenAiChatModel chatModel) {
        return ChatClient.builder(chatModel)
                .defaultSystem("You are a helpful AI Assistant answering questions about cities around the world.")
                .defaultFunctions("currentWeatherFunction")
                .build();
    }
}

package cryptoSentinel.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@AllArgsConstructor
public class WebClientConfig {

    private final UriProperties uriProperties;

    @Bean
    public WebClient coingeckoWebClient(WebClient.Builder builder) {
        return builder
                .baseUrl(uriProperties.getBaseUrl())
                .build();
    }

}

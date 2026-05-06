package cryptoSentinel.config;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "uri-properties")
public class UriProperties {

    private String baseUrl;
    private String CoinListUrl;
    private String CoinMarketUrl;

}

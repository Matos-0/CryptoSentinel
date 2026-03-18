package cryptoSentinel.config;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@ConfigurationProperties(prefix = "uri_properties")
public class UriProperties {

    private String baseUrl;
    private String CoinListUrl;
    private String CoinMarketUrl;

}

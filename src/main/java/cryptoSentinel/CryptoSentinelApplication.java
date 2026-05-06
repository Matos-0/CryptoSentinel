package cryptoSentinel;

import cryptoSentinel.config.UriProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.elasticsearch.repository.config.EnableReactiveElasticsearchRepositories;

@SpringBootApplication
@EnableReactiveElasticsearchRepositories
public class CryptoSentinelApplication {

    public static void main(String[] args) {
        SpringApplication.run(CryptoSentinelApplication.class, args);
    }

}

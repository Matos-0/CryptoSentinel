package cryptoSentinel.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import cryptoSentinel.config.UriProperties;
import cryptoSentinel.dto.CoinsMarketsDTO;
import cryptoSentinel.dto.query.CoinsMarketsQuery;
import cryptoSentinel.model.CoinsMarket;
import cryptoSentinel.repository.CoinsMarketRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
@AllArgsConstructor
public class CoinsMarketService {

    private final WebClient coingeckoWebClient;
    private final UriProperties uriProperties;
    private static final Logger log = LoggerFactory.getLogger(CoinsMarketService.class);
    private final ObjectMapper objectMapper;
    private final CoinsMarketRepository coinsMarketRepository;

    public Mono<String> getCoinMarket(CoinsMarketsQuery query) {

        Map<String, String> map = objectMapper.convertValue(query, new TypeReference<Map<String, String>>() {});
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.setAll(map);

        return coingeckoWebClient.get()
                .uri(uriBuilder -> uriBuilder
                            .path(uriProperties.getCoinMarketUrl())
                            .queryParams(queryParams)
                            .build()
                )
                .retrieve()
                .bodyToMono(CoinsMarketsDTO.class)
                .map(CoinsMarket::new)
                .flatMap(coinsMarketRepository::save)
                .doFinally(e ->
                    log.info("Error while trying to save data.: {}", e)
                )
                .map(CoinsMarket::getId)
                .onErrorResume(e -> {
                    log.error("Error processing API: {}", e.getMessage());
                    return Mono.empty();
                });
    }

    public void coinsMarkerInjection() {

        Flux<CoinsMarket> entityFlux = coingeckoWebClient.get()
                .uri(uriProperties.getCoinMarketUrl())
                .retrieve()
                .bodyToFlux(CoinsMarketsDTO.class)
                .map(entity -> new CoinsMarket());

        coinsMarketRepository.saveAll(entityFlux)
                .map(CoinsMarket::getId)
                .onErrorResume(e -> {
                    log.error("Error while trying to save data.: %s", e);
                    return Flux.empty();
                });
    }

}

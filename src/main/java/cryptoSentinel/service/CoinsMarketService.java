package cryptoSentinel.service;

import com.fasterxml.jackson.core.JsonProcessingException;
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
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
@AllArgsConstructor
public class CoinsMarketService {

    private final WebClient coingeckoWebClient;
    private final UriProperties uriProperties;
    private final CoinsMarketRepository coinsMarketRepository;
    private static final Logger log = LoggerFactory.getLogger(CoinsMarketService.class);
    private final ObjectMapper objectMapper;

    public Mono<Long> coinsMarketIngestion() {

        CoinsMarketsQuery query = new CoinsMarketsQuery();

        Map<String, Object> queryMap = objectMapper.convertValue(query, new TypeReference<Map<String, Object>>() {
        });

        return coingeckoWebClient.get()
                .uri(uriBuilder -> {
                    uriBuilder.path(uriProperties.getCoinMarketUrl());
                    queryMap.forEach((key, value) -> {
                        if (value != null) uriBuilder.queryParam(key, value);
                    });
                    return uriBuilder.build();
                })
                .retrieve()
                .bodyToFlux(CoinsMarketsDTO.class)
                .map(CoinsMarket::new)
                .flatMap(coin ->
                        coinsMarketRepository.save(coin)
                                .onErrorResume(e -> {
                                    log.error("Erro ao salvar moeda específica: {}", e.getMessage());
                                    return Mono.empty();
                                })
                )
                .count()
                .doOnNext(saved -> log.info("Total de ativos salvos: {}", saved))
                .doOnError(error -> log.error("Erro fatal no fluxo de ingestão: ", error))
                .doOnTerminate(() -> log.info("Processamento de ativos finalizado"));
    }

    // obtén dados direto da API -> Stream
    public Mono<String> getCoinsMarket(CoinsMarketsQuery query) {

        Map<String, Object> queryMap = objectMapper.convertValue(query, new TypeReference<Map<String, Object>>() {
        });

        return coingeckoWebClient.get()
                .uri(uriBuilder -> {
                    uriBuilder.path(uriProperties.getCoinMarketUrl());
                    queryMap.forEach((key, value) -> {
                        if (value != null) uriBuilder.queryParam(key, value);
                    });
                    return uriBuilder.build();
                })
                .retrieve()
                .bodyToFlux(CoinsMarketsDTO.class)
                .collectList()
                .flatMap(list -> {
                    try {
                        String json = objectMapper.writeValueAsString(list);
                        return Mono.just(json);
                    } catch (JsonProcessingException e) {
                        return Mono.error(new RuntimeException("Erro ao gerar Json: ", e));
                    }
                });
    }

}

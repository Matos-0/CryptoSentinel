package cryptoSentinel.service;

import cryptoSentinel.config.UriProperties;
import cryptoSentinel.dto.CoinsListDTO;
import cryptoSentinel.model.CoinsList;
import cryptoSentinel.repository.CoinsListRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class CoinsListService {

    private final WebClient coingeckoWebClient;
    private final CoinsListRepository coinsListRepository;
    private final UriProperties uriProperties;
    private static final Logger log = LoggerFactory.getLogger(CoinsListService.class);

    public Flux<CoinsListDTO> getRemoteCoins() {
        return coingeckoWebClient.get()
                .uri(uriProperties.getCoinListUrl())
                .retrieve()
                .bodyToFlux(CoinsListDTO.class);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runIngestion() {
        getRemoteCoins()
                .flatMap(dto -> {
                    CoinsList entity = new CoinsList(
                            dto.getId(),
                            dto.getSymbol(),
                            dto.getName(),
                            //todo: utilizar objeto específfico para receber e gravar `platforms`
                            null,
                            LocalDateTime.now()
                    );
                    return coinsListRepository.save(entity);
                })
                .doOnSubscribe(s -> log.info("Iniciando ingestão de moedas..."))
                .count()
                .subscribe(total -> log.info("Ingestão finalizada! Total de moedas salvas: {}", total));
    }

}

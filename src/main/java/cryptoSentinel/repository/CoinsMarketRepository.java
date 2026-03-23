package cryptoSentinel.repository;

import cryptoSentinel.model.CoinsMarket;
import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface CoinsMarketRepository extends ReactiveElasticsearchRepository<CoinsMarket, String> {

    Flux<CoinsMarket> save(String symbol);

    Flux<CoinsMarket> findBySymbol(String symbol);

}

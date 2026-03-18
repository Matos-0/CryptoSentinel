package cryptoSentinel.repository;

import cryptoSentinel.model.CoinsList;
import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface CoinsListRepository extends ReactiveElasticsearchRepository<CoinsList, String> {

    Flux<CoinsList> save(String symbol);

}

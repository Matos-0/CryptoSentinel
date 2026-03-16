package cryptoSentinel.repository;

import cryptoSentinel.model.CryptoPrice;
import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface CryptoPriceRepository extends ReactiveElasticsearchRepository<CryptoPrice, String> {

    Flux<CryptoPrice> findBySymbol(String symbol);

}

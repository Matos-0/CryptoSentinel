package cryptoSentinel.repository;

import cryptoSentinel.model.CoinsMarket;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.time.Instant;

@Repository
public interface CoinsMarketRepository extends R2dbcRepository<CoinsMarket, Long> {

    //buscar histórico por Symbol
    Flux<CoinsMarket> findAllBySymbol(String symbol, Instant time);

}
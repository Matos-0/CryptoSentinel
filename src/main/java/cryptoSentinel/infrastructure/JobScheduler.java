package cryptoSentinel.infrastructure;

import cryptoSentinel.service.CoinsMarketService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@EnableScheduling
public class JobScheduler {

    private final CoinsMarketService coinsMarketService;
    private static final Logger log = LoggerFactory.getLogger(JobScheduler.class);

    @Scheduled(cron = "0 */5 * * * *")
    public void coinsMarketSchedule() {
        coinsMarketService.coinsMarkerInjection();
        log.info("Iniciando ingestão do método CoinMarket");
    }

    //todo -> agendamento para sanitizar registros com mais de 7 dias

}

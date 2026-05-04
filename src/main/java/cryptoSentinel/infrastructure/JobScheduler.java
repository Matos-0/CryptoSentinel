package cryptoSentinel.infrastructure;

import cryptoSentinel.service.CoinsListService;
import cryptoSentinel.service.CoinsMarketService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@EnableScheduling
public class JobScheduler {

    private final CoinsListService coinsListService;
    private final CoinsMarketService coinsMarketService;
    private static final Logger log = LoggerFactory.getLogger(JobScheduler.class);

    @Scheduled(cron = "0 0 0 * * * ")
    public void coinListSchedule() {
        coinsListService.runIngestion();
    }

    @Scheduled(cron = "0 */5 * * * *")
    public void coinsMarketSchedule() {
        log.info("Iniciando ingestão do método CoinMarket");
        coinsMarketService.coinsMarketIngestion().subscribe();
    }

//    @EventListener(ApplicationReadyEvent.class)
//    public void testeInjection() {
//        log.info("Iniciando teste de ingestão CoinMarket");
//        coinsMarketService.coinsMarketIngestion().subscribe();
//    }

    //todo -> agendamento para sanitizar registros com mais de 7 dias

}

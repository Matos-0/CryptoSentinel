package cryptoSentinel.infrastructure;

import cryptoSentinel.service.CoinsListService;
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
    private static final Logger log = LoggerFactory.getLogger(JobScheduler.class);

    // Roda ao iniciar
    @EventListener(ApplicationReadyEvent.class)
    public void runOnStart() {
        coinsListService.runIngestion();
    }

    // Roda a cada 24 horas (exemplo)
    @Scheduled(cron = "0 0 * * * *")
    public void coinListSchedule() {
        coinsListService.runIngestion();
    }

}

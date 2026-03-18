package cryptoSentinel.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
public class CoinsMarketsDTO {

    private String id;

    private String symbol;

    private String name;

    private String image;

    private BigDecimal currentPrice;

    private BigDecimal marketCap;

    private Integer marketCapRank;

    private Integer marketCapRankWithRehypothecated;

    private BigDecimal fullyDilutedValuation;

    private BigDecimal totalVolume;

    private BigDecimal high24h;

    private BigDecimal low24h;

    private BigDecimal priceChange24h;

    private Double priceChangePercentage24h;

    private BigDecimal marketCapChange24h;

    private Double marketCapChangePercentage24h;

    private BigDecimal circulatingSupply;

    private BigDecimal totalSupply;

    private BigDecimal maxSupply;

    private BigDecimal ath;

    private Double athChangePercentage;

    private OffsetDateTime athDate;

    private BigDecimal atl;

    private Double atlChangePercentage;

    private OffsetDateTime atlDate;

    private String roi;

    private OffsetDateTime lastUpdated;

    public CoinsMarketsDTO(BigDecimal totalVolume, String id, String symbol, String name, String image, BigDecimal currentPrice, BigDecimal marketCap, Integer marketCapRank, Integer marketCapRankWithRehypothecated, BigDecimal fullyDilutedValuation, BigDecimal high24h, BigDecimal low24h, BigDecimal priceChange24h, Double priceChangePercentage24h, BigDecimal marketCapChange24h, Double marketCapChangePercentage24h, BigDecimal circulatingSupply, BigDecimal totalSupply, BigDecimal maxSupply, BigDecimal ath, Double athChangePercentage, OffsetDateTime athDate, BigDecimal atl, Double atlChangePercentage, OffsetDateTime atlDate, String roi, OffsetDateTime lastUpdated) {
        this.totalVolume = totalVolume;
        this.id = id;
        this.symbol = symbol;
        this.name = name;
        this.image = image;
        this.currentPrice = currentPrice;
        this.marketCap = marketCap;
        this.marketCapRank = marketCapRank;
        this.marketCapRankWithRehypothecated = marketCapRankWithRehypothecated;
        this.fullyDilutedValuation = fullyDilutedValuation;
        this.high24h = high24h;
        this.low24h = low24h;
        this.priceChange24h = priceChange24h;
        this.priceChangePercentage24h = priceChangePercentage24h;
        this.marketCapChange24h = marketCapChange24h;
        this.marketCapChangePercentage24h = marketCapChangePercentage24h;
        this.circulatingSupply = circulatingSupply;
        this.totalSupply = totalSupply;
        this.maxSupply = maxSupply;
        this.ath = ath;
        this.athChangePercentage = athChangePercentage;
        this.athDate = athDate;
        this.atl = atl;
        this.atlChangePercentage = atlChangePercentage;
        this.atlDate = atlDate;
        this.roi = roi;
        this.lastUpdated = lastUpdated;
    }

}

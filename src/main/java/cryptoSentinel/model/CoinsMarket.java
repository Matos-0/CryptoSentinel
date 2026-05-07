package cryptoSentinel.model;

import cryptoSentinel.dto.CoinsMarketsDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CoinsMarket {

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
    private CoinsMarketsDTO.RoiDTO roi;
    private OffsetDateTime lastUpdated;

    public CoinsMarket(CoinsMarketsDTO dto) {
        this.id = dto.getId();
        this.symbol = dto.getSymbol();
        this.name = dto.getName();
        this.image = dto.getImage();
        this.currentPrice = dto.getCurrentPrice();
        this.marketCap = dto.getMarketCap();
        this.marketCapRank = dto.getMarketCapRank();
        this.marketCapRankWithRehypothecated = dto.getMarketCapRankWithRehypothecated();
        this.fullyDilutedValuation = dto.getFullyDilutedValuation();
        this.totalVolume = dto.getTotalVolume();
        this.high24h = dto.getHigh24h();
        this.low24h = dto.getLow24h();
        this.priceChange24h = dto.getPriceChange24h();
        this.priceChangePercentage24h = dto.getPriceChangePercentage24h();
        this.marketCapChange24h = dto.getMarketCapChange24h();
        this.marketCapChangePercentage24h = dto.getMarketCapChangePercentage24h();
        this.circulatingSupply = dto.getCirculatingSupply();
        this.totalSupply = dto.getTotalSupply();
        this.maxSupply = dto.getMaxSupply();
        this.ath = dto.getAth();
        this.athChangePercentage = dto.getAthChangePercentage();
        this.athDate = dto.getAthDate();
        this.atl = dto.getAtl();
        this.atlChangePercentage = dto.getAtlChangePercentage();
        this.atlDate = dto.getAtlDate();
        this.lastUpdated = dto.getLastUpdated();
        if (dto.getRoi() != null) {
            this.roi = dto.getRoi();
        }
    }

}

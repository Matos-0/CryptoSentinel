package cryptoSentinel.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
public class CoinsMarketsDTO {

    @JsonProperty("id")
    private String id;

    @JsonProperty("symbol")
    private String symbol;

    @JsonProperty("name")
    private String name;

    @JsonProperty("image")
    private String image;

    @JsonProperty("current_price")
    private BigDecimal currentPrice;

    @JsonProperty("market_cap")
    private BigDecimal marketCap;

    @JsonProperty("market_cap_rank")
    private Integer marketCapRank;

    @JsonProperty("market_cap_rank_with_rehypothecated")
    private Integer marketCapRankWithRehypothecated;

    @JsonProperty("fully_diluted_valuation")
    private BigDecimal fullyDilutedValuation;

    @JsonProperty("total_volume")
    private BigDecimal totalVolume;

    @JsonProperty("high_24h")
    private BigDecimal high24h;

    @JsonProperty("low_24h")
    private BigDecimal low24h;

    @JsonProperty("price_change_24h")
    private BigDecimal priceChange24h;

    @JsonProperty("price_change_percentage_24h")
    private Double priceChangePercentage24h;

    @JsonProperty("market_cap_change_24h")
    private BigDecimal marketCapChange24h;

    @JsonProperty("market_cap_change_percentage_24h")
    private Double marketCapChangePercentage24h;

    @JsonProperty("circulating_supply")
    private BigDecimal circulatingSupply;

    @JsonProperty("total_supply")
    private BigDecimal totalSupply;

    @JsonProperty("max_supply")
    private BigDecimal maxSupply;

    @JsonProperty("ath")
    private BigDecimal ath;

    @JsonProperty("ath_change_percentage")
    private Double athChangePercentage;

    @JsonProperty("ath_date")
    private OffsetDateTime athDate;

    @JsonProperty("atl")
    private BigDecimal atl;

    @JsonProperty("atl_change_percentage")
    private Double atlChangePercentage;

    @JsonProperty("atl_date")
    private OffsetDateTime atlDate;

    @JsonProperty("roi")
    private RoiDTO roi;

    @JsonProperty("last_updated")
    private OffsetDateTime lastUpdated;

    public CoinsMarketsDTO(BigDecimal totalVolume, String id, String symbol, String name, String image, BigDecimal currentPrice, BigDecimal marketCap, Integer marketCapRank, Integer marketCapRankWithRehypothecated, BigDecimal fullyDilutedValuation, BigDecimal high24h, BigDecimal low24h, BigDecimal priceChange24h, Double priceChangePercentage24h, BigDecimal marketCapChange24h, Double marketCapChangePercentage24h, BigDecimal circulatingSupply, BigDecimal totalSupply, BigDecimal maxSupply, BigDecimal ath, Double athChangePercentage, OffsetDateTime athDate, BigDecimal atl, Double atlChangePercentage, OffsetDateTime atlDate, RoiDTO roi, OffsetDateTime lastUpdated) {
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

    @Data
    public static class RoiDTO {
        private Double times;
        private String currency;
        private Double percentage;
    }

}

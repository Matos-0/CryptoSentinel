package cryptoSentinel.model;

import cryptoSentinel.dto.CoinsMarketsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "coins_market")
public class CoinsMarket {

    @Id
    @Field(type = FieldType.Keyword)
    private String id;

    @Field(type = FieldType.Keyword)
    private String symbol;

    @Field(type = FieldType.Text)
    private String name;

    @Field(type = FieldType.Keyword, index = false)
    private String image;

    @Field(type = FieldType.Double)
    private BigDecimal currentPrice;

    @Field(type = FieldType.Double)
    private BigDecimal marketCap;

    @Field(type = FieldType.Integer)
    private Integer marketCapRank;

    @Field(type = FieldType.Integer)
    private Integer marketCapRankWithRehypothecated;

    @Field(type = FieldType.Double)
    private BigDecimal fullyDilutedValuation;

    @Field(type = FieldType.Double)
    private BigDecimal totalVolume;

    @Field(type = FieldType.Double)
    private BigDecimal high24h;

    @Field(type = FieldType.Double)
    private BigDecimal low24h;

    @Field(type = FieldType.Double)
    private BigDecimal priceChange24h;

    @Field(type = FieldType.Double)
    private Double priceChangePercentage24h;

    @Field(type = FieldType.Double)
    private BigDecimal marketCapChange24h;

    @Field(type = FieldType.Double)
    private Double marketCapChangePercentage24h;

    @Field(type = FieldType.Double)
    private BigDecimal circulatingSupply;

    @Field(type = FieldType.Double)
    private BigDecimal totalSupply;

    @Field(type = FieldType.Double)
    private BigDecimal maxSupply;

    @Field(type = FieldType.Double)
    private BigDecimal ath;

    @Field(type = FieldType.Double)
    private Double athChangePercentage;

    @Field(type = FieldType.Date, format = DateFormat.date_time)
    private OffsetDateTime athDate;

    @Field(type = FieldType.Double)
    private BigDecimal atl;

    @Field(type = FieldType.Double)
    private Double atlChangePercentage;

    @Field(type = FieldType.Date, format = DateFormat.date_time)
    private OffsetDateTime atlDate;

    @Field(type = FieldType.Keyword)
    private CoinsMarketsDTO.RoiDTO roi;

    @Field(type = FieldType.Date, format = DateFormat.date_time)
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
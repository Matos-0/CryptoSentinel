package cryptoSentinel.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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

    @Field(type = FieldType.Date)
    private OffsetDateTime athDate;

    private BigDecimal atl;

    private Double atlChangePercentage;

    @Field(type = FieldType.Date)
    private OffsetDateTime atlDate;

    private String roi;

    @Field(type = FieldType.Date)
    private OffsetDateTime lastUpdated;

}

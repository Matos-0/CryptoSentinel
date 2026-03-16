package cryptoSentinel.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "crypto_prices")
public class CryptoPrice {

    @Id
    private String id;

    private String symbol;

    private Double price;

    @Field(type = FieldType.Date)

    private LocalDateTime timestamp;

}

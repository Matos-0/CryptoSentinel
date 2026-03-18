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
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "coins_list")
public class CoinsList {

    @Id
    private String id;

    private String symbol;

    private String name;

    private String platforms;

    @Field(type = FieldType.Date)
    private LocalDateTime timestamp;

}

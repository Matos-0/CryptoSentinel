package cryptoSentinel.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CoinsListDTO {

    private String id;

    private String symbol;

    private String name;

    private String platforms;

    public CoinsListDTO(String id, String symbol, String name, String platforms) {
        this.id = id;
        this.symbol = symbol;
        this.name = name;
        this.platforms = platforms;
    }
}

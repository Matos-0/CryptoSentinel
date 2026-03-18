package cryptoSentinel.dto.query;

import cryptoSentinel.enums.IncludeTokensEnum;
import cryptoSentinel.enums.LocaleEnum;
import cryptoSentinel.enums.OrderEnum;
import cryptoSentinel.enums.PrecisionEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CoinsMarketsQuery {

    private String vs_currency = "usd";

    private String id;

    private String name;

    private String symbols;

    private IncludeTokensEnum include_tokens;

    private String category = "layer-1";

    private OrderEnum order;

    private int per_page;

    private int page;

    private boolean sparkline;

    private String price_change_percentage = "1h";

    private LocaleEnum localeEnum;

    private PrecisionEnum precision;

    private boolean include_rehypothecated = false;

}

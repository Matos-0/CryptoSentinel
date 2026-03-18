package cryptoSentinel.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrderEnum {

   market_cap_asc("market_cap_asc"),
   market_cap_desc("market_cap_desc"),
   volume_asc("volume_asc"),
   volume_desc("volume_desc"),
   id_asc("id_asc"),
   id_desc("id_desc");

   private final String value;

}

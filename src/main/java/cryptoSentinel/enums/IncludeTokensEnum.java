package cryptoSentinel.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum IncludeTokensEnum {

    top("top"),
    all("all");

    private final String value;
}

package cryptoSentinel.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum PrecisionEnum {

    FULL("full"),
    P0("0"),
    P1("1"),
    P2("2"),
    P3("3"),
    P4("4"),
    P5("5"),
    P6("6"),
    P7("7"),
    P8("8"),
    P9("9"),
    P10("10"),
    P11("11"),
    P12("12"),
    P13("13"),
    P14("14"),
    P15("15"),
    P16("16"),
    P17("17"),
    P18("18");

    private final String value;

    public static PrecisionEnum fromString(String text) {
        return Arrays.stream(PrecisionEnum.values())
                .filter(b -> b.value.equalsIgnoreCase(text))
                .findFirst()
                .orElse(null);
    }
}
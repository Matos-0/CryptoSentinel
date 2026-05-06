package cryptoSentinel.enums;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum LocaleEnum {

    ar("ar"),
    bg("bg"),
    cs("cs"),
    da("da"),
    de("de"),
    el("el"),
    en("en"),
    es("es"),
    fi("fi"),
    fr("fr"),
    he("he"),
    hi("hi"),
    hr("hr"),
    hu("hu"),
    id("id"),
    it("it"),
    ja("ja"),
    ko("ko"),
    lt("lt"),
    nl("nl"),
    no("no"),
    pl("pl"),
    pt("pt"),
    ro("ro"),
    ru("ru"),
    sk("sk"),
    sl("sl"),
    sv("sv"),
    th("th"),
    tr("tr"),
    uk("uk"),
    vi("vi"),
    zh("zh"),
    zhtw("zh-tw");

    private final String value;

}

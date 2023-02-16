package com.agarnerw.trubbishtranslate.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VerboseEffect {
    private String effect;
    @JsonProperty("short_effect")
    private String shortEffect;
    private NamedAPIResource language;
}

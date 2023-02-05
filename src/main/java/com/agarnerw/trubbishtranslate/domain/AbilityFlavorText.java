package com.agarnerw.trubbishtranslate.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AbilityFlavorText {
    @JsonProperty("flavor_text")
    private String flavorText;
    private NamedAPIResource language;
    @JsonProperty("version_group")
    private NamedAPIResource versionGroup;
}

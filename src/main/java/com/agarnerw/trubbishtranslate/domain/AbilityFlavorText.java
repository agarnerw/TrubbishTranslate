package com.agarnerw.trubbishtranslate.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AbilityFlavorText {
    private String flavor_text;
    private NamedAPIResource language;
    private NamedAPIResource version_group;
}

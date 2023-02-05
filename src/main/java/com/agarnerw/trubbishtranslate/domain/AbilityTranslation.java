package com.agarnerw.trubbishtranslate.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AbilityTranslation {
    private String name;
    private String flavorText;

}

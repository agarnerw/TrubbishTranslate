package com.agarnerw.trubbishtranslate.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class MoveTranslation {
    private String name;
    private String effectEntry;
    private String flavorTextEntry;
}

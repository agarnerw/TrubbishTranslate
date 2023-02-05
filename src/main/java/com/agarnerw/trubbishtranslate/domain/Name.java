package com.agarnerw.trubbishtranslate.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Name {
    private String name;
    private NamedAPIResource language;

}

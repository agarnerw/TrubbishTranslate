package com.agarnerw.trubbishtranslate.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@JsonIgnoreProperties
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Move {
    private List<Name> names;
    @JsonProperty("effect_entries")
    private List<VerboseEffect> effectEntries;
    @JsonProperty("flavor_text_entries")
    private List<FlavorText> flavorTextEntries;
}

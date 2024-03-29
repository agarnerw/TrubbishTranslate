package com.agarnerw.trubbishtranslate;

import com.agarnerw.trubbishtranslate.domain.Ability;
import com.agarnerw.trubbishtranslate.domain.FlavorText;
import com.agarnerw.trubbishtranslate.domain.Name;
import com.agarnerw.trubbishtranslate.domain.NamedAPIResource;

public class AbilityBuilders {
    static Ability getDefaultAbility(){
        NamedAPIResource languageAPIResource = NamedAPIResource.builder()
                .name(AbilityPresets.LANGUAGE)
                .url(AbilityPresets.URL).build();
        NamedAPIResource versionAPIResource = NamedAPIResource.builder()
                .name(AbilityPresets.GAME_VERSION)
                .url(AbilityPresets.URL).build();
        Name name = Name.builder()
                .language(languageAPIResource)
                .name(AbilityPresets.ABILITY_NAME).build();
        FlavorText flavorText = FlavorText.builder()
                .language(languageAPIResource)
                .flavorText(AbilityPresets.FLAVOR_TEXT)
                .version_group(versionAPIResource).build();
        Ability ability = Ability.builder()
                .name(AbilityPresets.ABILITY_NAME)
                .names(new Name[]{name})
                .flavor_text_entries(new FlavorText[]{flavorText}).build();
        return ability;
    }
}

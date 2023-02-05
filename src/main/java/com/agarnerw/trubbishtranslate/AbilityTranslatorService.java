package com.agarnerw.trubbishtranslate;

import com.agarnerw.trubbishtranslate.domain.Ability;
import com.agarnerw.trubbishtranslate.domain.AbilityFlavorText;
import com.agarnerw.trubbishtranslate.domain.AbilityTranslation;
import com.agarnerw.trubbishtranslate.domain.Name;
import org.springframework.stereotype.Service;

@Service
public class AbilityTranslatorService {
    public AbilityTranslation getTranslation(Ability ability, String language) {
        String name = "";
        for (Name abilityName : ability.getNames()) {
            if (abilityName.getLanguage().getName().equals(language)) {
                name = abilityName.getName();
            }

        }
        String flavorText = "";
        for (AbilityFlavorText abilityFlavorText : ability.getFlavor_text_entries()) {
            if ((abilityFlavorText.getLanguage().getName().equals(language))
                    && (abilityFlavorText.getVersion_group().getName().equals("sword-shield"))) {
                flavorText = abilityFlavorText.getFlavor_text();
            }
        }
        return new AbilityTranslation(name, flavorText);
    }
}
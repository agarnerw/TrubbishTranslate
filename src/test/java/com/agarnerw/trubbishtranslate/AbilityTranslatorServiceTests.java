package com.agarnerw.trubbishtranslate;

import com.agarnerw.trubbishtranslate.domain.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
@SpringBootTest
class AbilityTranslatorServiceTests {
    @Autowired
    private AbilityTranslatorService abilityTranslatorService;
    @Test
    void givenAbilityAndLanguage_whenGetTranslation_thenAbilityTranslationReturned() {
        Ability ability = AbilityBuilders.getDefaultAbility();
        String language = AbilityPresets.LANGUAGE;
        AbilityTranslation abilityTranslation = abilityTranslatorService
                .getTranslation(ability, language);
        Assertions.assertInstanceOf(AbilityTranslation.class, abilityTranslation);
        Assertions.assertEquals(AbilityPresets.ABILITY_NAME, abilityTranslation.getName());
        Assertions.assertEquals(AbilityPresets.FLAVOR_TEXT, abilityTranslation.getFlavorText());
    }
    @Test
    void givenAbilityAndWrongLanguage_whenGetTranslation_thenNoTranslationReturned() {
        Ability ability = AbilityBuilders.getDefaultAbility();
        String language = AbilityPresets.LANGUAGE;
        String wrongLanguage = "Korean";
        AbilityTranslation abilityTranslation = abilityTranslatorService
                .getTranslation(ability, wrongLanguage);
        Assertions.assertInstanceOf(AbilityTranslation.class, abilityTranslation);
        Assertions.assertNotEquals(AbilityPresets.ABILITY_NAME, abilityTranslation.getName());
        Assertions.assertNotEquals(AbilityPresets.FLAVOR_TEXT, abilityTranslation.getFlavorText());
    }
}

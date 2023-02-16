package com.agarnerw.trubbishtranslate;

import com.agarnerw.trubbishtranslate.domain.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TranslatorServiceTests {
    @Autowired
    private TranslatorService translatorService;
    @Test
    void givenAbilityAndLanguage_whenGetTranslation_thenAbilityTranslationReturned() {
        Ability ability = AbilityBuilders.getDefaultAbility();
        String language = AbilityPresets.LANGUAGE;
        AbilityTranslation abilityTranslation = translatorService
                .getAbilityTranslation(ability, language);
        Assertions.assertInstanceOf(AbilityTranslation.class, abilityTranslation);
        Assertions.assertEquals(AbilityPresets.ABILITY_NAME, abilityTranslation.getName());
        Assertions.assertEquals(AbilityPresets.FLAVOR_TEXT, abilityTranslation.getFlavorText());
    }
    @Test
    void givenAbilityAndWrongLanguage_whenGetTranslation_thenNoTranslationReturned() {
        Ability ability = AbilityBuilders.getDefaultAbility();
        String wrongLanguage = "Wooperian";
        Assertions.assertThrows(BadRequestException.class,
                () -> {
                    translatorService.getAbilityTranslation(ability, wrongLanguage);});
    }
}

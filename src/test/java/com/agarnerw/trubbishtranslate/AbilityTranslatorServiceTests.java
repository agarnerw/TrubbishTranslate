package com.agarnerw.trubbishtranslate;

import com.agarnerw.trubbishtranslate.domain.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
@SpringBootTest
public class AbilityTranslatorServiceTests {
    @Autowired
    private AbilityTranslatorService abilityTranslatorService;
    @Test
    void givenAbilityAndLanguage_whenGetTranslation_thenAbilityTranslationReturned() {
        // given
        Ability ability = AbilityBuilders.getDefaultAbility();
        String language = AbilityPresets.LANGUAGE;
        // when
        AbilityTranslation abilityTranslation = abilityTranslatorService
                .getTranslation(ability, language);
        // then
        Assertions.assertInstanceOf(AbilityTranslation.class, abilityTranslation);
        Assertions.assertEquals(AbilityPresets.ABILITY_NAME, abilityTranslation.getName());
        Assertions.assertEquals(AbilityPresets.FLAVOR_TEXT, abilityTranslation.getFlavorText());
    }
}
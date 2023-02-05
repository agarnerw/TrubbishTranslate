package com.agarnerw.trubbishtranslate;

import com.agarnerw.trubbishtranslate.domain.Ability;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class APIControllerTests {
    @Autowired
    APIController apiController;
    @MockBean
    PokeAPIClient pokeAPIClient;
    @MockBean
    AbilityTranslatorService abilityTranslatorService;

    @Test
    void givenAbilityNameAndLanguage_whenGetAbility_thenGetAbilityCalled(){
        apiController.getAbility(AbilityPresets.ABILITY_NAME, AbilityPresets.LANGUAGE);
        Mockito.verify(pokeAPIClient, Mockito.times(1))
                .getAbility(AbilityPresets.ABILITY_NAME);

    }
    @Test
    void givenAbilityNameAndLanguage_whenGetAbility_thenGetTranslationCalled(){
        Ability ability = AbilityBuilders.getDefaultAbility();
        Mockito.doReturn(ability).when(pokeAPIClient).getAbility(AbilityPresets.ABILITY_NAME);
        apiController.getAbility(AbilityPresets.ABILITY_NAME, AbilityPresets.LANGUAGE);
        Mockito.verify(abilityTranslatorService, Mockito.times(1))
                .getTranslation(ability, AbilityPresets.LANGUAGE);

    }
}

package com.agarnerw.trubbishtranslate;

import com.agarnerw.trubbishtranslate.domain.Ability;
import com.agarnerw.trubbishtranslate.domain.AbilityTranslation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIController {
    private final PokeAPIClient pokeAPIClient;
    private final AbilityTranslatorService abilityTranslatorService;
    public APIController(PokeAPIClient pokeAPIClient, AbilityTranslatorService abilityTranslatorService){
        this.pokeAPIClient = pokeAPIClient;
        this.abilityTranslatorService = abilityTranslatorService;
    }
    @GetMapping ("/ability/{abilityName}")
    public AbilityTranslation getAbility(@PathVariable String abilityName, @RequestParam String language){
        Ability ability = pokeAPIClient.getAbility(abilityName);
        return abilityTranslatorService.getTranslation(ability, language);
    }

}

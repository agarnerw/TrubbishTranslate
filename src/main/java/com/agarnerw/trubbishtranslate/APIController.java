package com.agarnerw.trubbishtranslate;

import com.agarnerw.trubbishtranslate.domain.Ability;
import com.agarnerw.trubbishtranslate.domain.AbilityTranslation;
import com.agarnerw.trubbishtranslate.domain.Move;
import com.agarnerw.trubbishtranslate.domain.MoveTranslation;
import org.springframework.web.bind.annotation.*;

@RestController
public class APIController {
    private final PokeAPIClient pokeAPIClient;
    private final TranslatorService translatorService;
    public APIController(PokeAPIClient pokeAPIClient, TranslatorService translatorService){
        this.pokeAPIClient = pokeAPIClient;
        this.translatorService = translatorService;
    }
    @GetMapping ("/ability/{abilityName}")
    public AbilityTranslation getAbility(@PathVariable String abilityName, @RequestParam String language){
        Ability ability = pokeAPIClient.getAbility(abilityName);
        return translatorService.getAbilityTranslation(ability, language);
    }
    @GetMapping ("/move/{moveName}")
    public MoveTranslation getMove(@PathVariable String moveName, @RequestParam String language){
        Move move = pokeAPIClient.getMove(moveName);
        return translatorService.getMoveTranslation(move, language);
    }

}

package com.agarnerw.trubbishtranslate;

import com.agarnerw.trubbishtranslate.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TranslatorService {
    private String getEffectTranslation(List<VerboseEffect> effectEntries, String language){
        String returnEffectEntry = "No Effect Entry found.";
        for (VerboseEffect effect : effectEntries){
            if (effect.getLanguage().getName().equals(language)){
                returnEffectEntry = effect.getEffect();
            }
        }
        return returnEffectEntry;
    }
    private String getNameTranslation(List<Name> names, String language) {
        String returnName = "";
        for (Name name : names) {
            if (name.getLanguage().getName().equals(language)) {
                returnName = name.getName();
            }
        }
        if(returnName == ""){
            throw new BadRequestException("Name not found for language " + language);
        }
        return returnName;
    }
    private String getFlavorTextTranslation(List<FlavorText> flavorTexts, String language){
        String returnFlavorText = "";
        for (FlavorText flavorText : flavorTexts) {
            if ((flavorText.getLanguage()
                    .getName()
                    .equals(language))
                    && (flavorText.getVersionGroup()
                    .getName()
                    .equals("sword-shield"))) {
                returnFlavorText = flavorText.getFlavorText();
            }
        }
        if(returnFlavorText == ""){
            throw new BadRequestException("Text not found for language " + language);
        }
        return returnFlavorText;
    }
    public MoveTranslation getMoveTranslation(Move move, String language){
        String name = getNameTranslation(move.getNames(), language);
        String flavorText = getFlavorTextTranslation(move.getFlavorTextEntries(), language);
        String effectEntry = getEffectTranslation(move.getEffectEntries(), language);
        return new MoveTranslation(name, effectEntry, flavorText);
    }
    public AbilityTranslation getAbilityTranslation(Ability ability, String language) {
        String name = getNameTranslation(ability.getNames(), language);
        String flavorText = getFlavorTextTranslation(ability.getFlavor_text_entries(), language);
        return new AbilityTranslation(name, flavorText);
    }
}
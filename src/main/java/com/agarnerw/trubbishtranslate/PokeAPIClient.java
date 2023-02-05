package com.agarnerw.trubbishtranslate;


import com.agarnerw.trubbishtranslate.domain.Ability;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

public interface PokeAPIClient {
    @GetExchange("/ability/{ability}")
    Ability getAbility(@PathVariable String ability);
}

package com.agarnerw.trubbishtranslate;


import com.agarnerw.trubbishtranslate.domain.Ability;
import com.agarnerw.trubbishtranslate.domain.Move;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

public interface PokeAPIClient {
    @GetExchange("/ability/{ability}")
    Ability getAbility(@PathVariable String ability);

    @GetExchange("/move/{name}")
    Move getMove(@PathVariable String name);
}

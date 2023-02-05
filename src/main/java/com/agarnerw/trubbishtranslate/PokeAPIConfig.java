package com.agarnerw.trubbishtranslate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class PokeAPIConfig {
    @Bean
    public PokeAPIClient pokeAPIClient(){
        WebClient webClient = WebClient.builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .build();
        HttpServiceProxyFactory factory =
                HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient)).build();
        return factory.createClient(PokeAPIClient.class);
    }
}

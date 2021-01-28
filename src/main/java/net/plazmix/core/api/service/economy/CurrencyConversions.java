package net.plazmix.core.api.service.economy;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@RequiredArgsConstructor
public class CurrencyConversions {

    @Getter
    private final Currency currency;
    private final Map<Currency, Float> currencies;

    public float getMultiplier(Currency otherCurrency) {
        return currencies.getOrDefault(otherCurrency, 1.0F);
    }
}

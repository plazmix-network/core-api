package net.plazmix.core.api.service.economy;

import java.util.concurrent.CompletableFuture;

public interface CurrencyConverter {

    CompletableFuture<ConversionInfo> convert(Account account, Currency from, Currency to, int sum, float multiplier);
}

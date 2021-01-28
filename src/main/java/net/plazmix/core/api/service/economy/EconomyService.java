package net.plazmix.core.api.service.economy;

import net.plazmix.core.api.service.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;

public interface EconomyService extends Service {

    CurrencyConversions getCurrencyConversions(Currency currency);

    CurrencyConverter getCurrencyConverter();

    TransactionManager getTransactionManager();

    Collection<String> getCurrencyCodes();

    Collection<Currency> getCurrencies();

    Optional<Currency> getCurrency(String code);

    Account getAccount(UUID uuid);

    Account saveAccount(Account account);

    default Supplier<Account> supplyAccount(UUID uuid) {
        return () -> getAccount(uuid);
    }
}

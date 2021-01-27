package net.plazmix.core.api.service.economy;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface TransactionManager {

    CompletableFuture<TransactionInfo> transact(Account from, Account to, Currency currency, int sum);

    CompletableFuture<TransactionInfo> transact(UUID from, UUID to, Currency currency, int sum);
}

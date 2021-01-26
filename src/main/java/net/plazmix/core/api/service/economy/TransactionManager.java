package net.plazmix.core.api.service.economy;

import java.util.concurrent.CompletableFuture;

public interface TransactionManager {

    CompletableFuture<TransactionInfo> transact(String from, String to, Currency currency, int sum);
}

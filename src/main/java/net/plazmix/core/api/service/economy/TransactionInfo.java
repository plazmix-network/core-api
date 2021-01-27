package net.plazmix.core.api.service.economy;

import lombok.Data;

import java.util.UUID;

@Data
public class TransactionInfo {

    private final TransactionResult result;
    private final Currency currency;
    private final UUID from, to;
    private final int sum;
}

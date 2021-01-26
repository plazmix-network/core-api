package net.plazmix.core.api.service.economy;

import lombok.Data;

@Data
public class TransactionInfo {

    private final TransactionResult result;
    private final Currency currency;
    private final String from, to;
    private final int sum;
}

package net.plazmix.core.api.service.economy;

import java.util.UUID;

public interface Account {

    UUID getUniqueId();

    Wallet getWallet(Currency currency);
}

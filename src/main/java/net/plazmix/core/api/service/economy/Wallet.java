package net.plazmix.core.api.service.economy;

import java.util.UUID;

public interface Wallet {

    UUID getOwnerId();

    Currency getCurrency();

    int getBalance();

    void setBalance(int balance);

    void deposit(int amount);

    void withdraw(int amount);
}

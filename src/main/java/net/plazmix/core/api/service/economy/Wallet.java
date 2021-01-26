package net.plazmix.core.api.service.economy;

public interface Wallet {

    Currency getCurrency();

    int getBalance();

    void setBalance(int balance);

    void deposit(int amount);

    void withdraw(int amount);
}

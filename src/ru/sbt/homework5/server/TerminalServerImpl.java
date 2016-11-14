package ru.sbt.homework5.server;


import ru.sbt.homework5.exception.NotEnoughMoneyException;

import java.net.ConnectException;
import java.util.Random;

public class TerminalServerImpl implements TerminalServer{
    private int balance;
    private final boolean isOverdraft;

    public TerminalServerImpl(int balance, boolean isOverdraft) {
        this.balance = balance;
        this.isOverdraft = isOverdraft;
    }

    @Override
    public int getBalance() throws ConnectException {
        if (new Random().nextInt() % 100 == 37) {
            throw new ConnectException();
        }
        return this.balance;
    }

    @Override
    public void add(int sum) throws ConnectException {
        if (new Random().nextInt() % 100 == 37) {
            throw new ConnectException();
        }
        this.balance += sum;
    }

    @Override
    public void withdraw(int sum) throws ConnectException, NotEnoughMoneyException {
        if (new Random().nextInt() % 100 == 37) {
            throw new ConnectException();
        }
        if (balance < sum) {
            if (isOverdraft) {
                this.balance -= sum;
            }
            else {
                throw new NotEnoughMoneyException();
            }
        }
        else {
            this.balance -= sum;
        }
    }
}

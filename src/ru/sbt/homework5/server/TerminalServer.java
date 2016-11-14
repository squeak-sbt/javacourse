package ru.sbt.homework5.server;


import ru.sbt.homework5.exception.NotEnoughMoneyException;

import java.net.ConnectException;

public interface TerminalServer {
    int getBalance() throws ConnectException;
    void add(int sum) throws ConnectException;
    void withdraw(int sum) throws ConnectException, NotEnoughMoneyException;
}

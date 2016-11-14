package ru.sbt.homework5.terminal;


import ru.sbt.homework5.exception.*;

import java.net.ConnectException;

public interface Terminal {
    int getBalance() throws ConnectException, NotValidatedPinException;
    void add(int sum) throws  WrongSumException, ConnectException, NotValidatedPinException;
    void withdraw(int sum) throws WrongSumException, NotEnoughMoneyException, ConnectException, NotValidatedPinException;
    void validatePin(String pin) throws AccounIsLockedException, InvalidPinException;
    boolean isValidated();
}

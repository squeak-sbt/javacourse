package ru.sbt.homework5.terminal;

import ru.sbt.homework5.server.TerminalServer;
import ru.sbt.homework5.exception.*;
import ru.sbt.homework5.validator.PinValidator;

import java.net.ConnectException;


public class TerminalImpl implements Terminal{
    private final TerminalServer server;
    private final PinValidator validator;
    private boolean isValidated;

    public TerminalImpl(TerminalServer server, PinValidator validator) {
        this.server = server;
        this.validator = validator;
        this.isValidated = false;
    }

    @Override
    public int getBalance()
            throws ConnectException, NotValidatedPinException {
        if (!isValidated) {
            throw new NotValidatedPinException();
        }
        return server.getBalance();
    }

    @Override
    public void add(int sum)
            throws WrongSumException, ConnectException, NotValidatedPinException {
        if (!isValidated) {
            throw new NotValidatedPinException();
        }
        if (sum % 100 != 0) {
            throw new WrongSumException();
        }
        server.add(sum);
    }

    @Override
    public void withdraw(int sum)
            throws WrongSumException,
            NotEnoughMoneyException, ConnectException, NotValidatedPinException {
        if (!isValidated) {
            throw new NotValidatedPinException();
        }
        if (sum % 100 != 0) {
            throw new WrongSumException();
        }
        server.withdraw(sum);
    }

    @Override
    public void validatePin(String pin) throws AccounIsLockedException, InvalidPinException {
        validator.validate(pin);
        isValidated = true;
    }

    @Override
    public boolean isValidated() {
        return this.isValidated;
    }
}

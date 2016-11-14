package ru.sbt.homework5.validator;

import ru.sbt.homework5.exception.AccounIsLockedException;
import ru.sbt.homework5.exception.InvalidPinException;

import java.util.Date;

public class PinValidatorImpl implements PinValidator{
    private Date lastWrongAttempt;
    private int wrongAttemptsCount;
    private boolean isLocked;
    private final String pin;

    public PinValidatorImpl(String pin) {
        this.wrongAttemptsCount = 0;
        this.isLocked = false;
        this.pin = pin;
    }

    @Override
    public void validate(String pin) throws AccounIsLockedException, InvalidPinException {
        if (isLocked && (new Date().getTime() - lastWrongAttempt.getTime()) / 1000 < 5) {
            throw new AccounIsLockedException(5 - (int)((new Date().getTime() - lastWrongAttempt.getTime()) / 1000));
        }
        else {
            if (this.pin.equals(pin)) {
                rightAttempt();
            }
            else {
                wrongAttempt();
            }
        }
    }

    private void wrongAttempt() throws InvalidPinException, AccounIsLockedException {
        wrongAttemptsCount++;
        lastWrongAttempt = new Date();
        if (wrongAttemptsCount >= 3) {
            isLocked = true;
            throw new AccounIsLockedException(5 - (int)((new Date().getTime() - lastWrongAttempt.getTime()) / 1000));
        }
        throw new InvalidPinException(3 - wrongAttemptsCount);
    }

    private void rightAttempt(){
        wrongAttemptsCount = 0;
        isLocked = false;
    }

}

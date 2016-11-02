package ru.sbt.homework5.validator;

import ru.sbt.homework5.exception.AccounIsLockedException;
import ru.sbt.homework5.exception.InvalidPinException;

public interface PinValidator {
    void validate(String pin) throws AccounIsLockedException, InvalidPinException;
}

package ru.sbt.homework5;


import ru.sbt.homework5.exception.*;
import ru.sbt.homework5.server.TerminalServer;
import ru.sbt.homework5.server.TerminalServerImpl;
import ru.sbt.homework5.terminal.Terminal;
import ru.sbt.homework5.terminal.TerminalImpl;
import ru.sbt.homework5.validator.PinValidator;
import ru.sbt.homework5.validator.PinValidatorImpl;

import java.net.ConnectException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PinValidator validator = new PinValidatorImpl("1234");
        TerminalServer server = new TerminalServerImpl(500, false);
        Terminal terminal = new TerminalImpl(server, validator);
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Hello! Please enter command:\n" +
                    "\"add\" - to add money into card\n" +
                    "\"balance\" - to get card balance\n" +
                    "\"get\" - to get money\n" +
                    "\"exit\" - to exit");
            try {
                execCommand(in.next(), terminal, in);
            } catch (CallExitException e) {
                System.out.println("Goodbye!");
                return;
            }
        }
    }

    private static void execCommand(String next, Terminal terminal, Scanner in) throws CallExitException {
        switch (next) {
            case "add":
                System.out.println("Adding money. Enter sum:");
                int sum = in.nextInt();
                try {
                    terminal.add(sum);
                }
                catch (NotValidatedPinException e){
                    validate(in, terminal);
                    execCommand(next, terminal, in);
                } catch (ConnectException e) {
                    System.out.println("Error: Connection is lost, try later.");
                }
                catch (WrongSumException e) {
                    System.out.println("Error: Expected sum, which is mulptiple to 100.");
                }
                break;
            case "balance":
                try {
                    System.out.println(terminal.getBalance());
                } catch (ConnectException e) {
                    System.out.println("Error: Connection is lost, try later.");
                } catch (NotValidatedPinException e) {
                    validate(in, terminal);
                    execCommand(next, terminal, in);
                }
                break;
            case "get":
                System.out.println("Getting money. Enter sum:");
                sum = in.nextInt();
                try {
                    terminal.withdraw(sum);
                } catch (NotValidatedPinException e) {
                    validate(in, terminal);
                } catch (ConnectException e) {
                    System.out.println("Error: Connection is lost, try later.");
                } catch (NotEnoughMoneyException e) {
                    System.out.println("Error: You have not enough money.");
                } catch (WrongSumException e) {
                    System.out.println("Error: Expected sum, which is mulptiple to 100.");
                }
                break;
            case "exit":
                throw new CallExitException();
            default:
                System.out.println("Uknown command.");
        }
    }

    private static void validate(Scanner in, Terminal terminal) {
        while(!terminal.isValidated()) {
            System.out.println("Please enter your PIN number:");
            try {
                terminal.validatePin(in.next());
            } catch (AccounIsLockedException e) {
                System.out.println("Error: Your card is locked for " + e.getRemainingSeconds() + " seconds.");
            } catch (InvalidPinException e) {
                System.out.println("Error: Invalid PIN number. Remaining attempts: " + e.getRemainingAttempts());
            }
        }
    }


}

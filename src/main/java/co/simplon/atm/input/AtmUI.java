package co.simplon.atm.input;

import java.util.Scanner;

public class AtmUI {
    private final Scanner scanner;

    public AtmUI() {
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("insert your card (by type number account)");
        //client enter account
        String accountNumber = scanner.nextLine();

        //client insert card with infos
        Card card = new Card(accountNumber, "456", false);

        //verify card already unlocked
        if (!card.isUnlocked()) {
            unlock(card);
        } else {
            authenticate(card);
        }

        displayMenu();
        String choice = scanner.nextLine().trim();
        switch (choice) {
            case "1":
                //withdraw(cardNumber);
                break;
            case "2":
                //requestBalance(cardNumber);
                break;
            case "3":
                System.out.println("Goodbye!");
                scanner.close();
                return;
            default:
                System.out.println("Invalid option, try again!");
        }

        //}
    }

    private void unlock(Card card) {
        int t = 0;
        while (t < 3) {
            System.out.print("Enter code pin: ");

            String enteredPin = scanner.nextLine();
            if (card.checkPin(enteredPin)) {
                card.setUnlocked(true);
                System.out.println("Code pin valid with success!");
                break;
            } else {
                System.out.println("try again, you have 3 times to try");
            }
            t = t + 1;
        }
    }

    private void displayMenu() {
        System.out.println("\n1. Withdraw");
        System.out.println("2. Request balance");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
    }

    private void authenticate(Card card) {
        int t = 0;

        while (t < 3) {
            System.out.print("Enter code pin: ");

            String enteredPin = scanner.nextLine();
            if (card.checkPin(enteredPin)) {
                System.out.println("Authentication successful!");
                break;
            } else {
                System.out.println("try again, you have 3 times to try");
            }
            t = t + 1;
        }
    }

//    private void withdraw(String cardNumber) {
//        System.out.print("enter amount: ");
//        int amount = scanner.nextInt();
//        operation.withdraw(amount, cardNumber);
//    }
//
//    private void requestBalance(String cardNumber) {
//        long balance = operation.requestBalance(cardNumber);
//        System.out.println("your balance is " + balance + " euros");
//    }

}

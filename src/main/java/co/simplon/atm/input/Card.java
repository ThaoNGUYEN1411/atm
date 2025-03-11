package co.simplon.atm.input;

public class Card {
    private final String accountNumber;
    private final String codePin;
    private boolean unlocked;

    public Card(String accountNumber, String codePin, boolean unlocked) {
        this.accountNumber = accountNumber;
        this.codePin = codePin;
        this.unlocked = unlocked;
    }

    public String getCardNumber() {
        return accountNumber;
    }

    public String getCodePin() {
        return codePin;
    }

    public boolean isUnlocked() {
        return unlocked;
    }

    public void setUnlocked(boolean unlocked) {
        this.unlocked = unlocked;
    }

    public boolean checkPin(String pin) {
        // unlocked = true;
        return pin.equals(codePin);
    }


    @Override
    public String toString() {
        return "Card{" +
                "cardNumber='" + accountNumber + '\'' +
                ", codePin='" + codePin + '\'' +
                ", unlocked=" + unlocked +
                '}';
    }
}

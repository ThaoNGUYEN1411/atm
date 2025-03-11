package co.simplon.atm.service;

import co.simplon.atm.bankservice.AccountInfoResponse;
import co.simplon.atm.bankservice.FileResponse;
import co.simplon.atm.input.Card;

import java.util.List;

public class Operation {
    private final List<Card> cards;

    private final int localCash;

    private final AccountInfoResponse accountInfo;

//    public Operation() {
//        this.cards = new ArrayList<>();
//    }


    public Operation(List<Card> cards, int localCash) {
        this.cards = cards;
        this.localCash = localCash;
        accountInfo = null;
    }

//    public void addCard(String cardNumber, String codePin, boolean active) {
//        cards.add(new Card(cardNumber, codePin, active));
//    }

    public Card findCard(String cardNumber) {
        for (Card card : cards) {
            if (card.getCardNumber().equalsIgnoreCase(cardNumber)) {
                return card;
            }
        }
        return null;
    }

    public void withdraw(int amount, String cardNumber) {
        if (amount > localCash) {
            System.out.println("Not enough local cash");
        }

        //call bank with amount and cardNumber

        // Load JSON data
        FileResponse fileResponse = new FileResponse("src/main/resources/responseData.json");

        //Get and display the bank response
        AccountInfoResponse response = fileResponse.getAccountInfoResponse();

        if (response.bankAvailable()) {
            if (response.getAllowWithdraw()) {
                System.out.println("withdraw success");
            } else {
                System.out.println("withdraw error");
            }
        } else {
            System.out.println("Bank not available");
        }
    }

    public long requestBalance(String cardNumber) {
        // Load JSON data
        FileResponse fileResponse = new FileResponse("src/main/resources/responseData.json");

        //Get and display the bank response
        AccountInfoResponse response = fileResponse.getAccountInfoResponse();

        return response.getBalance();
    }
}

//constructor with argument or not??
//variable final or not??
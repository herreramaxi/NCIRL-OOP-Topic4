/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greetingcards;

import greetingcards.Interfaces.IGreetingCard;
import greetingcards.Interfaces.IPrintableGreetingCard;
import java.util.ArrayList;

/**
 *
 * @author Maximiliano Herrera
 */
public class GreetingCardsMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<IGreetingCard> cards = new ArrayList<>();

        //Creating Birthday, Christmas and Wedding greeting cards
        cards.add(GreetingCardFactory.Create("Recipient A", "Sender A", GreetingCardType.Birthday));
        cards.add(GreetingCardFactory.Create("Recipient B", "Sender B", GreetingCardType.Christmas));
        cards.add(GreetingCardFactory.Create("Recipient C", "Sender C", GreetingCardType.Wedding));

        //Print X times each card to test random saludations, verses and closings.
        cards.forEach((card) -> {
            PrintGreetingCardXTimes(card, 2);
        });
    }

    private static void PrintGreetingCardXTimes(IGreetingCard card, int quantity) {
        System.out.println(card.getClass().getSimpleName());

        PrintCardXTimes(quantity, () -> card.salutation());
        PrintCardXTimes(quantity, () -> card.verse());
        PrintCardXTimes(quantity, () -> card.closing());

        System.out.println("------------------------------------------");
    }

    private static void PrintCardXTimes(int quantity, IPrintableGreetingCard printableGreetingCard) {
        for (int i = 0; i < quantity; i++) {
            printableGreetingCard.Print();
            System.out.print("\n\n");
        }
    }
}

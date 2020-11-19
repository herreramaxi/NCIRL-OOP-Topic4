package greetingcards;

import greetingcards.GreetingCards.BirthdayGreetingCard;
import greetingcards.GreetingCards.ChristmasGreetingCard;
import greetingcards.GreetingCards.WeddingGreetingCard;
import greetingcards.Interfaces.IGreetingCard;
import greetingcards.Interfaces.IGreetingCardBuilder;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Maximiliano Herrera
 */
public class GreetingCardFactory {

    public static IGreetingCard Create(String recipient, String sender, GreetingCardType greetingCardType) {
        IGreetingCardBuilder card;
        switch (greetingCardType) {
            case Birthday:
                card = new BirthdayGreetingCard(recipient, sender);
                break;
            case Christmas:
                card = new ChristmasGreetingCard(recipient, sender);
                break;
            case Wedding:
                card = new WeddingGreetingCard(recipient, sender);
                break;
            default:
                throw new IllegalArgumentException();
        }

        //initialise is only exposed to GreetingCardFactory through IGreetingCardBuilder.
        card.initialise();

        return card;
    }
}

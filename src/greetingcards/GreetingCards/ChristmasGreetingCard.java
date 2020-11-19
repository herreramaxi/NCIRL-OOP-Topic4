/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greetingcards.GreetingCards;

/**
 *
 * @author Maximiliano Herrera
 */
public class ChristmasGreetingCard extends GreetingCard {

    public ChristmasGreetingCard(String recipient, String sender) {
        super(recipient, sender);
    }

    @Override
    protected void initialiseSaludations() {
        this.AddSaludation("Christmas Saludation 1");
        this.AddSaludation("Christmas Saludation 2");
        this.AddSaludation("Christmas Saludation 3");
    }

    @Override
    protected void initialiseVerses() {
        this.addVerse("Christmas Verse 1");
        this.addVerse("Christmas Verse 2");
        this.addVerse("Christmas Verse 3");
    }

    @Override
    protected void initialiseClosings() {
        this.addClosing("Christmas Closing 1");
        this.addClosing("Christmas Closing 2");
        this.addClosing("Christmas Closing 3");
    }
}

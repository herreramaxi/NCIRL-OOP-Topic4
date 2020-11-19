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
public class WeddingGreetingCard extends GreetingCard {

    public WeddingGreetingCard(String recipient, String sender) {
        super(recipient, sender);
    }

    @Override
    protected void initialiseSaludations() {
        this.AddSaludation("Wedding Saludation 1");
        this.AddSaludation("Wedding Saludation 2");
        this.AddSaludation("Wedding Saludation 3");
    }

    @Override
    protected void initialiseVerses() {
        this.addVerse("Wedding Verse 1");
        this.addVerse("Wedding Verse 2");
        this.addVerse("Wedding Verse 3");
    }

    @Override
    protected void initialiseClosings() {
        this.addClosing("Wedding Closing 1");
        this.addClosing("Wedding Closing 2");
        this.addClosing("Wedding Closing 3");
    }
}

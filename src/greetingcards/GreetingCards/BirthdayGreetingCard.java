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
public class BirthdayGreetingCard extends GreetingCard {

   public BirthdayGreetingCard(String recipient, String sender) {
        super(recipient, sender);
    }

    @Override
    protected void initialiseSaludations() {
        this.AddSaludation("Birthday Saludation 1");
        this.AddSaludation("Birthday Saludation 2");
        this.AddSaludation("Birthday Saludation 3");
    }

    @Override
    protected void initialiseVerses() {
        this.addVerse("Birthday Verse 1");
        this.addVerse("Birthday Verse 2");
        this.addVerse("Birthday Verse 3");
    }

    @Override
    protected void initialiseClosings() {
        this.addClosing("Birthday Closing 1");
        this.addClosing("Birthday Closing 2");
        this.addClosing("Birthday Closing 3");
    }


}

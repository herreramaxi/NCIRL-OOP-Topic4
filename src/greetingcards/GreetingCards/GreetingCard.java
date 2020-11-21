/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greetingcards.GreetingCards;

import greetingcards.Interfaces.IGreetingCardBuilder;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Maximiliano Herrera
 */
public abstract class GreetingCard implements IGreetingCardBuilder {

    private final String recipient;
    private final String sender;
    private ArrayList<String> saludations;
    private ArrayList<String> verses;
    private ArrayList<String> closings;
    private final Random random;

    @Override
    public String getRecipient() {
        return recipient;
    }

    @Override
    public String getSender() {
        return sender;
    }

    public GreetingCard(String recipient, String sender) {
        this.random = new Random();
        this.closings = new ArrayList<>();
        this.verses = new ArrayList<>();
        this.saludations = new ArrayList<>();
        this.recipient = recipient;
        this.sender = sender;
    }

    //Template method
    @Override
    public void initialise() {
        initialiseSaludations();
        initialiseVerses();
        initialiseClosings();
    }

    protected abstract void initialiseSaludations();

    protected abstract void initialiseVerses();

    protected abstract void initialiseClosings();

    //Template method print
    @Override
    public void print() {
        salutation();
        verse();
        closing();
    }

    //choose a random salutation from the array and print alongside the recipient name     
    protected void salutation() {
        String saludation = this.getRandomFrom(saludations);

        StringBuilder sb = new StringBuilder(saludation).append(" ");
        sb.append(this.recipient).append(",\n");

        System.out.print(sb.toString());
    }

    //choose and print a random verse from the array    
    protected void verse() {
        String verse = this.getRandomFrom(verses);
        System.out.print(verse);
        System.out.print("\n");
    }

    //choose a random closing from the array and print alongside the sender sender
    protected void closing() {
        String closing = this.getRandomFrom(closings);
        StringBuilder sb = new StringBuilder(closing).append("\n");
        sb.append(this.sender);

        System.out.print(sb.toString());
    }

    protected void AddSaludation(String saludation) {
        saludations.add(saludation);
    }

    protected void addVerse(String verse) {
        verses.add(verse);
    }

    protected void addClosing(String closing) {
        closings.add(closing);
    }

    private String getRandomFrom(ArrayList<String> arrayList) {
        int randomIndex = random.nextInt(arrayList.size());
        return arrayList.get(randomIndex);
    }

}

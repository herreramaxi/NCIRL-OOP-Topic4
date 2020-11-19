/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import greetingcards.GreetingCards.BirthdayGreetingCard;
import greetingcards.GreetingCards.ChristmasGreetingCard;
import greetingcards.GreetingCardFactory;
import greetingcards.GreetingCardType;
import greetingcards.Interfaces.IGreetingCard;
import greetingcards.GreetingCards.WeddingGreetingCard;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

/**
 *
 * @author Maximiliano Herrera
 */
public class GreetingCardUnitTests {

    private static ArrayList<String> saludations;
    private static ArrayList<String> verses;
    private static ArrayList<String> closings;

    public GreetingCardUnitTests() {
    }

    @BeforeClass
    public static void setUpClass() {

        saludations = new ArrayList<>();
        saludations.add("saludation1");
        saludations.add("saludation2");

        verses = new ArrayList<>();
        verses.add("verse1");
        verses.add("verse2");

        closings = new ArrayList<>();
        closings.add("closing1");
        closings.add("closing2");
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void WhenAskingForAChristmasGreetingCardAGreetingCardIsGenerated() {
        String recipient = "a recipient";
        String sender = "a sender";
        IGreetingCard greetingCard = GreetingCardFactory.Create(recipient, sender, GreetingCardType.Christmas);
        assertTrue(greetingCard instanceof ChristmasGreetingCard);
        assertFalse(greetingCard instanceof WeddingGreetingCard);
        assertFalse(greetingCard instanceof BirthdayGreetingCard);
    }

    @Test
    public void WhenAskingForABirthdayGreetingCardABrithdayCardIsGenerated() {
        String recipient = "a recipient";
        String sender = "a sender";
        IGreetingCard greetingCard = GreetingCardFactory.Create(recipient, sender, GreetingCardType.Birthday);
        assertFalse(greetingCard instanceof ChristmasGreetingCard);
        assertFalse(greetingCard instanceof WeddingGreetingCard);
        assertTrue(greetingCard instanceof BirthdayGreetingCard);
    }

    @Test
    public void WhenAskingForAWeddingGreetingCardAWeddingCardIsGenerated() {
        String recipient = "a recipient";
        String sender = "a sender";
        IGreetingCard greetingCard = GreetingCardFactory.Create(recipient, sender, GreetingCardType.Wedding);
        assertFalse(greetingCard instanceof ChristmasGreetingCard);
        assertTrue(greetingCard instanceof WeddingGreetingCard);
        assertFalse(greetingCard instanceof BirthdayGreetingCard);
    }

    @Test
    public void WhenCreatingACardTheSenderAndReceiverIsTheExpected() {
        String recipient = "a recipient a";
        String sender = "a sender b";
        ArrayList<IGreetingCard> cards = new ArrayList<>();

        cards.add(GreetingCardFactory.Create(recipient, sender, GreetingCardType.Birthday));
        cards.add(GreetingCardFactory.Create(recipient, sender, GreetingCardType.Christmas));
        cards.add(GreetingCardFactory.Create(recipient, sender, GreetingCardType.Wedding));

        for (IGreetingCard card : cards) {
            assertThat(card.getRecipient(), is(recipient));
            assertThat(card.getSender(), is(sender));
        }
    }   
}

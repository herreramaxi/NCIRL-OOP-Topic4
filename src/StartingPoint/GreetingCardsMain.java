/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StartingPoint;

import greetingcards.Interfaces.IGreetingCard;
import greetingcards.Interfaces.IPrintableGreetingCard;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import com.google.common.base.Strings;
import greetingcards.CustomOutputStream;
import greetingcards.GreetingCardFactory;
import greetingcards.GreetingCardType;
import java.awt.HeadlessException;
import java.io.PrintStream;

/**
 *
 * @author Maximiliano Herrera
 */
public class GreetingCardsMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String selectedValue = selectExecutionMode();

        if (selectedValue == "UI") {
            ExecuteUIMode();
        } else if (selectedValue == "Console example") {
            ExecuteConsoleMode();
        } else {
            throw new IllegalArgumentException();
        }
    }

    private static void ExecuteUIMode() {
        StringBuilder outputStringBuilder = new StringBuilder();
        //Redirect System.out to a stringBuilder
        PrintStream printStream = new PrintStream(new CustomOutputStream(outputStringBuilder));
        System.setOut(printStream);

        String recipient = AskForInputAndRetry("Please enter recipient:");
        String sender = AskForInputAndRetry("Please enter sender:");

        if (Strings.isNullOrEmpty(recipient) || Strings.isNullOrEmpty(sender)) {
            //I am adding a very simple validation in order to avoid errors in later stage.
            JOptionPane.showMessageDialog(null, "Recipient and sender are mandatory. Exiting application.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Object[] possibleValues = GreetingCardType.values();
        Object cardType = JOptionPane.showInputDialog(null,
                "Please select a greeting card", "Greeting card selection",
                JOptionPane.INFORMATION_MESSAGE, null,
                possibleValues, possibleValues[0]);

        IGreetingCard card = GreetingCardFactory.Create(recipient, sender, (GreetingCardType) cardType);
        card.print();

        JOptionPane.showMessageDialog(null, outputStringBuilder.toString());
    }

    private static void ExecuteConsoleMode() {
        ArrayList<IGreetingCard> cards = new ArrayList<>();

        //Creating Birthday, Christmas and Wedding greeting cards
        cards.add(GreetingCardFactory.Create("Recipient A", "Sender A", GreetingCardType.Birthday));
        cards.add(GreetingCardFactory.Create("Recipient B", "Sender B", GreetingCardType.Christmas));
        cards.add(GreetingCardFactory.Create("Recipient C", "Sender C", GreetingCardType.Wedding));

        //Print X times each card to test random saludations, verses and closings.
        cards.forEach((card) -> {
            PrintGreetingCardXTimes(card, 3);
        });
    }

    private static void PrintGreetingCardXTimes(IGreetingCard card, int quantity) {
        System.out.println("Printing greeting card '" + card.getClass().getSimpleName() + "' " + quantity + " times:");
        System.out.println("-----------------------------------------------------------");
//        System.out.println(card.getClass().getSimpleName());

        PrintCardXTimes(quantity, () -> card.print());

        System.out.println("-------------------------------------------------------------------------------------------");
    }

    private static void PrintCardXTimes(int quantity, IPrintableGreetingCard printableGreetingCard) {
        for (int i = 0; i < quantity; i++) {
            printableGreetingCard.Print();
            System.out.print("\n\n");
        }
    }

    private static String selectExecutionMode() {
        Object[] possibleValues = {"UI", "Console example"};
        Object selectedValue = JOptionPane.showInputDialog(null,
                "Select execution mode", "Execution mode selection",
                JOptionPane.INFORMATION_MESSAGE, null,
                possibleValues, possibleValues[0]);

        return selectedValue == null ? "" : selectedValue.toString();
    }

    private static String AskForInputAndRetry(String message) {
        int retries = 0;
        String input;
        do {
            input = JOptionPane.showInputDialog(message);
            retries++;
        } while (Strings.isNullOrEmpty(input) && retries < 3);
        return input;
    }
}

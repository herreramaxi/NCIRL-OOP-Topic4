/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greetingcards.Interfaces;

/**
 *
 * @author Maximiliano Herrera
 */
//This interface expose the initialise operation to GreetingCardFactory which
//is in charge of creating objects of the family IGreetingCard.
public interface IGreetingCardBuilder extends IGreetingCard {

    void initialise();
}

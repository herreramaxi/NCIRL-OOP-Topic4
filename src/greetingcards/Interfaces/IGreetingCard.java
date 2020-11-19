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
public interface IGreetingCard {

    String getRecipient();

    String getSender();

    void salutation();

    void verse();

    void closing();
}

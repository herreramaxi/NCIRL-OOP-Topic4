/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greetingcards;

//@reference: https://www.codejava.net/java-se/swing/redirect-standard-output-streams-to-jtextarea
import java.io.IOException;
import java.io.OutputStream;

public class CustomOutputStream extends OutputStream {

    private StringBuilder sb;

    public CustomOutputStream(StringBuilder sb) {
        this.sb = sb;
    }

    @Override
    public void write(int b) throws IOException {
        this.sb.append(String.valueOf((char) b));
    }
}

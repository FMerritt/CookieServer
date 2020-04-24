import java.net.*;
import java.io.*;

public class CookieProtocol {
    private static final int WAITING = 0;
    private static final int SENTACK = 1;
    private static final int SENTFORTUNE = 2;
    private static final int ANOTHER = 3;

    private static final int NUMJOKES = 5;

    private int state = WAITING;

    public String processInput(String theInput) {
        String theOutput = null;

        if (state == WAITING) {
            theOutput = "Connecting to <host name> on port <port number>";
            state = SENTACK;
        } else if (state == SENTACK) {
                theOutput = "Go for the gold today! You’ll be the champion of whatever.";
                state = SENTFORTUNE;
            }
         else if (state == SENTFORTUNE) {
                theOutput = " Want another? (y/n)";
                state = ANOTHER;
            }
         else if (state == ANOTHER) {
            if (theInput.equalsIgnoreCase("y")) {
                theOutput = "Every flower blooms in its own sweet time.";
                state = SENTFORTUNE;
            } 
            else {
                theOutput = "Bye.";
                state = WAITING;
            }
        }
        return theOutput;
    }
}
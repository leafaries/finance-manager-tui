package archives.gpt;

import com.googlecode.lanterna.gui2.WindowBasedTextGUI;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.gui2.BasicWindow;

import java.io.IOException;

public class WindowUtils {

    public static void closeWindowOnKeyPress(WindowBasedTextGUI gui, BasicWindow window, KeyType keyType) {
        // Run the key listening in a separate thread to keep the UI responsive
        new Thread(() -> {
            try {
                // Keep checking for key press
                while (true) {
                    KeyStroke keyStroke = gui.getScreen().pollInput();
                    if (keyStroke != null && keyStroke.getKeyType() == keyType) {
                        System.out.println("ESC registered, closing window");
                        window.close(); // Close the window when the specified key is pressed
                        break;
                    }
                    Thread.sleep(100); // Poll every 100 ms
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}

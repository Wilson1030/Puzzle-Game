package GUI;

import javax.swing.*;

public class RegisterJFrame extends JFrame{
    // Contains all the logic of the game regist

    public RegisterJFrame() {
        // Set the width and height of the interface
        this.setSize(488, 500);
        // Set the title of the interface
        this.setTitle("拼图 注册");
        // Set the interface top
        this.setAlwaysOnTop(true);
        // Set the interface to center
        this.setLocationRelativeTo(null);
        // Set off mode
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // Let the interface display
        this.setVisible(true);
    }
}

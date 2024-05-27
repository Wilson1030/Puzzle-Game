package GUI;

import javax.swing.*;

public class GameJFrame extends JFrame{
    // Contains all the logic of the game

    public GameJFrame() {
        // Initialization JFrame
        initJFrame();
        // Initialization menu
        initJMenuBar();
        // Initialization image
        initImage();
        // Let the interface display
        this.setVisible(true);
    }

    private void initJFrame() {
        // Set the width and height of the interface
        this.setSize(603, 680);
        // Set the title of the interface
        this.setTitle("拼图单机版 v1.0");
        // Set the interface top
        this.setAlwaysOnTop(true);
        // Set the interface to center
        this.setLocationRelativeTo(null);
        // Set off mode
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    private void initImage() {
        // Create ImageIcon
        ImageIcon icon = new ImageIcon("D:\\Visual Studio Code\\Java\\Self-Study\\拼图小游戏\\Image\\animal\\animal3\\3.jpg");
        // Create JLabel
        JLabel jLabel = new JLabel(icon);
        // Designated spot
        jLabel.setBounds(0, 0, 105, 105);
        // Put Jlabel into menu
        this.add(jLabel);
    }

    private void initJMenuBar() {
        // Initialization menu
        // Create menu objects
        JMenuBar jMenuBar = new JMenuBar();
        
        // Create menu options
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");

        // Create an option entry object
        JMenuItem replayItem = new JMenuItem("重新游戏");
        JMenuItem reLoginItme = new JMenuItem("重新登录");
        JMenuItem closeItem = new JMenuItem("关闭游戏");
        
        JMenuItem accountItem = new JMenuItem("公众号");

        // Add entries under options to options
        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItme);
        functionJMenu.add(closeItem);
        
        aboutJMenu.add(accountItem);

        // Add options to the menu
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);

        // Set the menu of the interface
        this.setJMenuBar(jMenuBar);

    }
}
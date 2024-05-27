package GUI;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.util.Random;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameJFrame extends JFrame implements KeyListener{
    // Contains all the logic of the game

    // Create two-dimensional array to store data
    int[][] data = new int[4][4];
    
    // Record the position of the blank box
    int x = 0;
    int y = 0;

    // Define the correct array
    int[][] win = {
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 15, 16}
    };

    // Define the path
    String path = "Image\\animal\\animal3\\";

    public GameJFrame() {
        // Initialization JFrame
        initJFrame();
        // Initialization menu
        initJMenuBar();
        // Initialization image order
        initData();
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
        // De-centralize
        this.setLayout(null);
        // Add keyboard monitor events to the entire interface
        this.addKeyListener(this);
    }

    private void initImage() {
        // Delete all the image in the interface
        this.getContentPane().removeAll();

        if (victory()) {
            JLabel winJLabel = new JLabel(new ImageIcon("Image\\win.png"));
            winJLabel.setBounds(203, 283, 197, 73);
            this.getContentPane().add(winJLabel);
        }
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                // Gets the image loading sequence number
                int num = data[i][j];
                JLabel jLabel = new JLabel(new ImageIcon(path + num + ".jpg"));
                // Designated spot
                jLabel.setBounds(105 * j + 83, 105 * i + 134, 105, 105);
                // Add a border to the picture
                jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
                // Put Jlabel into menu
                this.getContentPane().add(jLabel);
            }
        }

        // Add image background
        JLabel background = new JLabel(new ImageIcon("Image\\background.png"));
        background.setBounds(40, 40, 508, 560);
        // Add image background into interface
        this.getContentPane().add(background);
        // Refresh the interface
        this.getContentPane().repaint();
    }

    // Shuffle pictures
    private void initData() {
        int[] tempArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Random r = new Random();
        for (int i = 0; i < tempArr.length; i++) {
            int index = r.nextInt(tempArr.length);
            int temp = tempArr[i];
            tempArr[i] = tempArr[index];
            tempArr[index] = temp;
        }
        for (int i = 0; i < tempArr.length; i++) {
            if (tempArr[i] == 0) {
                x = i / 4;
                y = i % 4;
            } else {
                data[i / 4][i % 4] = tempArr[i];
            }
        }

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

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == 65) {
            // Delete all image in the interface
            this.getContentPane().removeAll();
            // Load the complete image
            JLabel all = new JLabel(new ImageIcon(path + "all.jpg"));
            all.setBounds(83, 134, 420, 420);
            this.getContentPane().add(all);
            // Load the background image
            JLabel background = new JLabel(new ImageIcon("Image\\background.png"));
            background.setBounds(40, 40, 508, 560);
            // Add image background into interface
            this.getContentPane().add(background);
            // Refresh the interface
            this.getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Judge whether win the game
        if (victory()) {
            return;
        }
        
        // Judge position
        // Left: 37; Right: 39; Up: 38; Down: 40
        int code = e.getKeyCode();
        if (code == 37) {
            if (y == 3) {
                return;
            }
            data[x][y] = data[x][y + 1];
            data[x][y + 1] = 0;
            y++;
            initImage();
        } else if (code == 38) {
            if (x == 3) {
                return;
            }
            data[x][y] = data[x + 1][y];
            data[x + 1][y] = 0;
            x++;
            initImage();
        } else if (code == 39) {
            if (y == 0) {
                return;
            }
            data[x][y] = data[x][y - 1];
            data[x][y - 1] = 0;
            y--;
            initImage();
        } else if (code == 40) {
            if (x == 0) {
                return;
            }
            data[x][y] = data[x - 1][y];
            data[x - 1][y] = 0;
            x--;
            initImage();
        } else if (code == 65) {
            initImage();
        } else if (code == 87) {
            data = new int[][] {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
            };
            initImage();
        }
    }

    // Judge whether the same as win array
    public boolean victory() {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] != win[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
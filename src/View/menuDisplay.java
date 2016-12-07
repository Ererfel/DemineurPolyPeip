package View;

import javafx.scene.image.Image;

import javax.swing.*;

/**
 * Created by user on 07/12/16.
 */
public class menuDisplay {
    private JButton playButton;
    private JButton scoresButton;
    private JButton settingsButton;
    private JPanel main;
    public menuDisplay(){
        settingsButton.setText("Settings");
        playButton.setBorderPainted(false);
        scoresButton.setBorderPainted(false);
        settingsButton.setBorderPainted(false);
    }
    public JPanel getMain(){
        return main;
    }
}

package View;

import javafx.scene.image.Image;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by user on 07/12/16.
 */
public class menuDisplay {
    private JButton playButton;
    private JButton scoresButton;
    private JButton settingsButton;
    private JPanel main;
    Screen screen;
    public menuDisplay(Screen screen){
        this.screen = screen;
        settingsButton.setText("Settings");
        playButton.setBorderPainted(false);
        scoresButton.setBorderPainted(false);
        settingsButton.setBorderPainted(false);
        playButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                screen.gameMenu();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        settingsButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Screen.mainScreen.toSettings();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

    }
    public JPanel getMain(){
        return main;
    }
}

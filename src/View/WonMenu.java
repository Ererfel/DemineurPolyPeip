package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by user on 03/01/17.
 */
public class WonMenu {
    private JLabel scoreLabel;
    private JButton MENUButton;
    private JButton QUITButton;
    private JPanel main;

    public WonMenu(int Score) {
    scoreLabel.setText(String.valueOf(Score));
        MENUButton.addMouseListener(new MenuButtonListener());
        QUITButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Screen.mainScreen.dispose();
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

    public JPanel getMain() {
        return main;

    }

}

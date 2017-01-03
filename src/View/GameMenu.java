package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by user on 03/01/17.
 */
public class GameMenu {
    private JLabel inGame;
    private JLabel timeLabel;
    private JLabel timer;
    private JLabel mines;
    private JLabel size;
    private JPanel main;
    private JButton menu;

    public GameMenu(Screen screen) {
        new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.setText(screen.getTime());
            }
        }).start();
        menu.addMouseListener(new MenuButtonListener());
    }

    public JPanel getMain() {
        return main;
    }


    public JLabel getTimeLabel() {
        return timeLabel;
    }

    public JLabel getTimer() {
        return timer;
    }

    public JLabel getMines() {
        return mines;
    }

    public JLabel getSize() {
        return size;
    }
}

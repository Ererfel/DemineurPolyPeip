package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Show menu in side panel when the player looses
 */
public class LostMenu extends JPanel{
    Screen screen;
    public LostMenu(Screen screen) {
        this.screen= screen;

        setBackground(Color.BLACK);
        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weighty=0.8;
        constraints.weightx =1;

        JLabel lostLabel = new JLabel("<html><body><div style='text-align: center;'>  You <br> Lost </div></body></html>");
        lostLabel.setForeground(Color.LIGHT_GRAY);
        lostLabel.setFont(lostLabel.getFont().deriveFont(60f));

        layout.addLayoutComponent(lostLabel,constraints);
        add(lostLabel);

        JButton toMenu =  new JButton("MENU");
        toMenu.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        toMenu.setForeground(Color.lightGray);
        toMenu.setBackground(Color.darkGray);
        toMenu.setFont(toMenu.getFont().deriveFont(45f));

        toMenu.addMouseListener(new MenuButtonListener());

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weighty=0.1;

        layout.addLayoutComponent(toMenu,constraints);
        add(toMenu);

        JButton quit = new JButton("QUIT");
        quit.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        quit.setForeground(Color.lightGray);
        quit.setBackground(Color.darkGray);
        quit.setFont(quit.getFont().deriveFont(50f));
        quit.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                screen.dispose();
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

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weighty=0.1;
        constraints.weightx =1;
        layout.addLayoutComponent(quit,constraints);
        add(quit);

    }

}

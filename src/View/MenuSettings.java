package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by user on 03/01/17.
 */
public class MenuSettings {
    private JPanel main;
    private JTextField Width;
    private JTextField Height;
    private JTextField Mines;
    private JComboBox gridSetting;
    private JPanel CustomSettings;
    private JButton OKButton;

    public MenuSettings() {
        gridSetting.addItem("Easy");
        gridSetting.addItem("Normal");
        gridSetting.addItem("Hard");
        gridSetting.addItem("Custom");

        updateInfos(0);
        gridSetting.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateInfos(gridSetting.getSelectedIndex());
            }
        });
        OKButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int[] settings = parseSettings();
                Screen.mainScreen.getGame().newSettings(settings);
                Screen.mainScreen.toMenu();
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

    private int[] parseSettings() {
        int[] out = new int[3];

        out[0] = Integer.parseInt(Width.getText());
        out[1] = Integer.parseInt(Height.getText());
        out[2] = Integer.parseInt(Mines.getText());

        return out;
    }

    private void updateInfos(int selectedIndex) {
        String width = new String();
        String height = new String();
        String mines = new String();

        switch (selectedIndex){
            case 0:
                    width = "8";
                    mines = "10";
                break;
            case 1:
                width = "12";
                mines ="15";
                break;
            case 2:
                width = "15";
                mines = "20";
                break;

        }
        height =width;
        if(selectedIndex == 3){
            Width.setEditable(true);
            Height.setEditable(true);
            Mines.setEditable(true);

        }
        else{

            Width.setText(width);
            Width.setEditable(false);
            Height.setText(height);
            Height.setEditable(false);
            Mines.setText(mines);
            Mines.setEditable(false);

        }
    }

    public JPanel getMain() {
        return main;
    }
}

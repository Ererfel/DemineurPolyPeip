package View;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.*;

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
    private int width,height,mines;

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
                Screen.mainScreen.toMenu(true);
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
        Width.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                width = Integer.parseInt(Width.getText());
            }
        });
        Height.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                height = Integer.parseInt(Height.getText());
            }
        });
        Mines.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                mines = Integer.parseInt(Mines.getText());
            }
        });
    }

    private int[] parseSettings() {
        int[] out = new int[3];
        if(gridSetting.getSelectedIndex()==3){
            out[0] = width;
            out[1] = height;
            out[2] = mines;
            System.out.println("custom mode");

        }
        else{
            out[0] = Integer.parseInt(Width.getText());
            out[1] = Integer.parseInt(Height.getText());
            out[2] = Integer.parseInt(Mines.getText());

        }

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
            this.width = Integer.parseInt(width);
            this.height = Integer.parseInt(height);
            this.mines = Integer.parseInt(mines);
        }
    }

    public JPanel getMain() {
        return main;
    }
}

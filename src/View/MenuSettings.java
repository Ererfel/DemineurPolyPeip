package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by user on 03/01/17.
 */
public class MenuSettings {
    private JPanel main;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JComboBox gridSetting;
    private JPanel InfoDisplay;
    private JLabel infos;
    private JPanel CustomSettings;

    public MenuSettings() {
        gridSetting.addItem("Easy");
        gridSetting.addItem("Normal");
        gridSetting.addItem("Hard");
        gridSetting.addItem("Custom");

        updateInfos(0);
        CustomSettings.setVisible(false);
        gridSetting.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateInfos(gridSetting.getSelectedIndex());
            }
        });
    }

    private void updateInfos(int selectedIndex) {
        switch (selectedIndex){
            case 0:
                infos.setText("Easy 8x8 10 Mines");
                break;
            case 1:
                infos.setText("Normal  12x12 15 Mines");
                break;
            case 2:
                infos.setText("Hard 15x15 20 Mines");
                break;

        }
        CustomSettings.setVisible(false);
        infos.setVisible(true);
        if(selectedIndex == 3){
            infos.setVisible(false);
        CustomSettings.setVisible(true);}
    }

    public JPanel getMain() {
        return main;
    }
}

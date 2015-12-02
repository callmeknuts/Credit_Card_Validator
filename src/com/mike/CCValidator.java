package com.mike;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Mike on 12/1/2015.
 */
public class CCValidator extends JFrame {
    private JTextField creditCardNumberTextField;
    private JButton validateButton;
    private JButton quitButton;
    private JPanel rootPanel;
    private JLabel validMessageLabel;

    public CCValidator() {
        super("Credit Card Validator");
        setContentPane(rootPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        validateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String ccNumber = creditCardNumberTextField.getText();
                boolean valid = Main.luhn_check(ccNumber);
                if (valid) {
                    validMessageLabel.setText("Credit card number is valid.");
                } else {
                    validMessageLabel.setText("Credit card is Not valid sucka.");
                }
            }
        });
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
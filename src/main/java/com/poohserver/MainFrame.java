package com.poohserver;

import com.poohserver.model.NumberToWords;
import com.poohserver.model.SpellChecker;
import com.poohserver.view.InputForum;
import com.poohserver.view.OutputForum;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private InputForum inputForum;
    private OutputForum outputForum;
    private JButton switchButton;
    private SpellChecker spellChecker;
    private boolean isInputForumVisible = true; // Track the currently visible panel

    public MainFrame() {
        spellChecker = new SpellChecker("/home/pooh/Documents/sussex/furtherprogramming/le-gui-assesmentv2electric-bongaloo/Assets/test.txt");
        spellChecker.setRandomSelect();
        System.out.println(this.spellChecker.getRandomSelect());
        setTitle("Main Application");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Handle closing manually
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        inputForum = new InputForum("please spell out " + this.spellChecker.getRandomSelect(),this::windowSwitcher);
        outputForum = new OutputForum("", this::windowSwitcher, "");

        mainPanel.add(inputForum, "INPUT_FORUM");
        mainPanel.add(outputForum, "ANOTHER_DISPLAY");

        switchButton = new JButton("Switch Display");
        switchButton.addActionListener(this::windowSwitcher);


        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(mainPanel, BorderLayout.CENTER);

        // Set the initial display
        cardLayout.show(mainPanel, "INPUT_FORUM");

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int choice = JOptionPane.showConfirmDialog(
                        MainFrame.this, "Are you sure you want to exit?", "Exit Confirmation",
                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                if (choice == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        setVisible(true);
    }

    private void windowSwitcher(ActionEvent e){
        if (isInputForumVisible) {
            cardLayout.show(mainPanel, "ANOTHER_DISPLAY");
            String msg = this.inputForum.getText();
            System.out.println(msg);
            boolean result = this.spellChecker.run(msg);
            if (result){
             this.outputForum.setTextMessage("correct");
             this.outputForum.setIcon("/home/pooh/Documents/sussex/furtherprogramming/le-gui-assesmentv2electric-bongaloo/Assets/yes.png");
            }
            else {
                this.outputForum.setTextMessage("WRONG The CorrectSpelling is: " + NumberToWords.numberToWords(this.spellChecker.getRandomSelect()));
                this.outputForum.setIcon("/home/pooh/Documents/sussex/furtherprogramming/le-gui-assesmentv2electric-bongaloo/Assets/no.png");
            }
            isInputForumVisible = false;
        } else {
            this.spellChecker.setRandomSelect();
            System.out.println(this.spellChecker.getRandomSelect());
            this.inputForum.setLabelText("please spell out " + this.spellChecker.getRandomSelect());
            cardLayout.show(mainPanel, "INPUT_FORUM");
            isInputForumVisible = true;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainFrame();
            }
        });
    }
}
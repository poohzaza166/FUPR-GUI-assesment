package com.poohserver.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OutputForum extends JPanel {
    private JLabel label;
    private JButton optionA;
    private JButton optionB;
    private JLabel image;

    // Internal reference to the text.
    private String textMessage;

    public OutputForum(String text, ActionListener e) {
        this.textMessage = text;
        this.label = new JLabel(this.textMessage, SwingConstants.CENTER);
        this.optionA = new JButton("exit");
        this.optionB = new JButton("try again");
        this.image = new JLabel("", SwingConstants.CENTER);

        // Set the panel layout to BorderLayout.
        setLayout(new BorderLayout());

        // Add the label at the top.
        add(label, BorderLayout.NORTH);

        // Add the image in the center.
        add(image, BorderLayout.CENTER);

        // Create a panel for the buttons.
        JPanel buttonPanel = new JPanel(new BorderLayout());
        // Add optionA to the west and optionB to the east.
        buttonPanel.add(optionA, BorderLayout.WEST);
        buttonPanel.add(optionB, BorderLayout.EAST);
        // Add the button panel to the bottom.
        add(buttonPanel, BorderLayout.SOUTH);

        // Attach action listeners.
        this.optionA.addActionListener(this::exitProgram);
        // Optionally, add an action listener to optionB if needed.
         this.optionB.addActionListener(e);
    }

    public void setIcon(String imagePath) {
        ImageIcon icon = new ImageIcon(imagePath);
        Image scaledImage = icon.getImage();
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        this.image.setIcon(scaledIcon);
        this.revalidate();
        this.repaint();
    }

    private void exitProgram(ActionEvent actionEvent) {
        System.out.println("Exiting the program");
        System.exit(0);
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
        this.label.setText(textMessage);
        this.revalidate();
        this.repaint();
    }

    // Test method
//    public static void main(String[] args) {
//        OutputForum outputForum = new OutputForum("Hello World");
//        outputForum.setIcon("/home/pooh/Documents/sussex/furtherprogramming/le-gui-assesmentv2electric-bongaloo/Assets/__shiroko_blue_archive_drawn_by_harada_sansei_rain__6f87fa92a477f19799faee8ed6d5758c.png");
//
//        JFrame frame = new JFrame("OutputForum");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(400, 400);
//        frame.add(outputForum);
//        frame.setVisible(true);
//    }
}

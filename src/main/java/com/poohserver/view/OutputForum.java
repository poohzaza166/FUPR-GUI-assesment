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
    private JLabel correctSpellinglable;

    // Internal reference to the text.
    private String textMessage;

    /**
     * this is a cponstructor method for the OutputFourm
     * @param text this is a inital text message for the output forum
     * @param e Action Listenner
     */
    public OutputForum(String text, ActionListener e) {
        this.textMessage = text;
        // Set a kid-friendly pastel background color.
        setBackground(new Color(173, 216, 230)); // Light blue

        // Create and style the label.
        this.label = new JLabel(this.textMessage, SwingConstants.CENTER);
        this.label.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
        this.label.setForeground(new Color(255, 105, 180)); // Hot pink

        // Create and style the buttons.
        this.optionA = new JButton("Exit");
        this.optionB = new JButton("Try Again");
        styleButton(optionA);
        styleButton(optionB);

        // Set up the image label.
        this.image = new JLabel("", SwingConstants.CENTER);

        // Set the panel layout to BorderLayout with gaps.
        setLayout(new BorderLayout(10, 10));

        // Add the label at the top.
        add(label, BorderLayout.NORTH);

        // Add the image in the center.
        add(image, BorderLayout.CENTER);

        // Create a panel for the buttons.
        JPanel buttonPanel = new JPanel(new BorderLayout(10, 10));
        buttonPanel.setBackground(new Color(173, 216, 230)); // Match background

        // Add optionA to the west and optionB to the east.
        buttonPanel.add(optionA, BorderLayout.WEST);
        buttonPanel.add(optionB, BorderLayout.EAST);

        // Add the button panel to the bottom.
        add(buttonPanel, BorderLayout.SOUTH);

        // Attach action listeners.
        this.optionA.addActionListener(this::exitProgram);
        this.optionB.addActionListener(e);
    }

    // Helper method to style buttons.
    private void styleButton(JButton button) {
        button.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        button.setBackground(new Color(255, 182, 193)); // Light pink
        button.setForeground(Color.DARK_GRAY);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createRaisedBevelBorder());
    }

    /**
     * icon setter method
     * @param imagePath take the image path in
     */
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

    /**
     * getter method
     * @return Current text message String
     */
    public String getTextMessage() {
        return textMessage;
    }

    /**
     * settter function and repaint the lable
     * @param textMessage
     */
    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
        this.label.setText(textMessage);
        this.revalidate();
        this.repaint();
    }
}

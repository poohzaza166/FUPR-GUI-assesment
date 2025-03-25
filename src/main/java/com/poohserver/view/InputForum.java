package com.poohserver.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class InputForum extends JPanel {
    private JButton nextButton;
    private JTextField textInput;
    private JLabel label;
    private String text;
    private String labelText;

    public InputForum(String startingText, ActionListener listener){
        // Set layout with horizontal and vertical gaps
        setLayout(new BorderLayout(10, 10));

        // Set a kid-friendly pastel background color
        setBackground(new Color(173, 216, 230)); // Light blue

        this.labelText = startingText;

        // Create and style the label
        label = new JLabel(this.labelText, SwingConstants.CENTER);
        label.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
        label.setForeground(new Color(255, 105, 180)); // Hot pink

        // Create and style the text field
        textInput = new JTextField();
        textInput.setSize(30,40);
        textInput.setFont(new Font("Comic Sans MS", Font.PLAIN, 68));
        textInput.setBackground(Color.WHITE);
        textInput.setForeground(Color.BLACK);
        textInput.setBorder(BorderFactory.createLineBorder(new Color(255, 105, 180), 2));

        // Create and style the button
        nextButton = new JButton("Submit");
        nextButton.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        nextButton.setBackground(new Color(255, 182, 193)); // Light pink
        nextButton.setForeground(Color.DARK_GRAY);
        nextButton.addActionListener(listener);
        nextButton.setFocusPainted(false);
        nextButton.setBorder(BorderFactory.createRaisedBevelBorder());

        // Add components to the panel
        add(label, BorderLayout.NORTH);
        add(textInput, BorderLayout.CENTER);
        add(nextButton, BorderLayout.EAST);

        // Increase the preferred size to make it more accessible
        setPreferredSize(new Dimension(600, 100));
    }

    public String getText(){
        this.text = textInput.getText();
        return this.text;
    }

    public void setLabelText(String text){
        this.labelText = text;
        this.label.setText(this.labelText);
        revalidate();
        repaint();
    }
}

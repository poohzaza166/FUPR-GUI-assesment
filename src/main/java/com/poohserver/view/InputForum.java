package com.poohserver.view;

import javax.swing.*;
import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class InputForum extends JPanel {
    // defineing all of the iput forum element
    private JButton nextButton;
    private JTextField textInput;
    private JLabel lable;
    private String text;
    private String lableText;
    public InputForum(String startingText, ActionListener listener){
        setLayout(new BorderLayout());
        this.lableText = startingText;
        this.textInput = new JTextField();
        this.lable = new JLabel(this.lableText);
        this.nextButton = new JButton("subbmit");
        this.nextButton.addActionListener(listener);
        add(textInput, BorderLayout.CENTER);
        add(lable, BorderLayout.NORTH);
        add(nextButton, BorderLayout.EAST);
        setSize(600,800);
    }

    public String getText(){
        this.text = textInput.getText();
        return this.text;
    }

    public void setLableText(String text){
        this.lableText = text;
        this.lable.setText(this.lableText);
        this.revalidate();
        this.repaint();
    }
    private static void exit_program(WindowEvent e){
        System.exit(0);
    }

    // test method
//    public static void main(String[] args){
//        InputForum forum = new InputForum();
//        forum.setVisible(true);
//        forum.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                int choice = JOptionPane.showConfirmDialog(
//                        forum, "Are you sure you want to exit?", "Exit Confirmation",
//                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
//
//                if (choice == JOptionPane.YES_OPTION) {
//                    System.exit(0);
//                }
//            }
//        });
//    }
}

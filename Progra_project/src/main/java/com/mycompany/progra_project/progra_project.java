package com.mycompany.progra_project;

import Logic.Airplane;
import Logic.Flight;
import Logic.Invoice;
import Logic.Passenger;
import Logic.Reservation;
import Logic.Ticket;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class progra_project {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Airline Ticket Reservation");
            frame.setSize(450, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new GridLayout(8, 2, 5, 5));

            // Flight data
            Airplane airplane = new Airplane();
            Flight flight = new Flight("FL123", "New York", "London", airplane);

            // Input fields
            JTextField nameField = new JTextField();
            JTextField emailField = new JTextField();
            JTextField phoneField = new JTextField();
            JComboBox<String> seatClassBox = new JComboBox<>(new String[]{"Business", "Economy"});

            frame.add(new JLabel("Passenger Name:"));
            frame.add(nameField);
            frame.add(new JLabel("Email:"));
            frame.add(emailField);
            frame.add(new JLabel("Phone:"));
            frame.add(phoneField);
            frame.add(new JLabel("Class:"));
            frame.add(seatClassBox);

            JButton checkButton = new JButton("Check Availability");
            JButton reserveButton = new JButton("Reserve Ticket");
            JTextArea outputArea = new JTextArea();
            outputArea.setEditable(false);

            frame.add(checkButton);
            frame.add(reserveButton);
            frame.add(new JScrollPane(outputArea));

            // Action to check availability
            checkButton.addActionListener(e -> {
                String seatClass = (String) seatClassBox.getSelectedItem();
                int availableSeats;
                if (seatClass.equalsIgnoreCase("Business")) {
                    availableSeats = airplane.getBusinessSeats();
                } else {
                    availableSeats = airplane.getEconomySeats();
                }
                outputArea.setText(String.valueOf(availableSeats));
            });

            // Action to reserve ticket
            reserveButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Passenger passenger = new Passenger(
                            nameField.getText(),
                            emailField.getText(),
                            phoneField.getText()
                    );
                    String seatClass = (String) seatClassBox.getSelectedItem();
                    Ticket ticket = Reservation.reserveSeat(flight, passenger, seatClass);
                    if (ticket != null) {
                        Invoice invoice = new Invoice(ticket);
                        outputArea.setText(invoice.getInvoiceInfo());
                    } else {
                        outputArea.setText("Reservation failed. No seats available.");
                    }
                }
            });

            frame.setVisible(true);
        });
    }
}
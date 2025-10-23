package com.mycompany.progra_project;

import domain.Airplane;
import domain.Flight;
import domain.Invoice;
import domain.Passenger;
import domain.Reservation;
import domain.Ticket;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author luzma
 */
public class Progra_project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Airplane plane1 = new Airplane("BASIC-100", 2, 2); // 2 business, 2 economy
        Flight f1 = new Flight("New York", "Brazil", plane1, 120.0, 1.7,"01-11-2025", "14:00"); // economy price = 120, Business = 120*1.7

        Airplane plane2 = new Airplane("BASIC-200", 2, 2);
        Flight f2 = new Flight("Costa Rica", "Panama", plane2, 110.0, 1.6, "15-11-2025", "08:00");
        
        Airplane plane3 = new Airplane("BASIC-300", 2, 2);
        Flight f3 = new Flight("Spain", "France", plane3, 130.0, 1.5, "22-11-2025", "15:00");
        
        Airplane plane4 = new Airplane("BASIC-400", 2, 2);
        Flight f4 = new Flight("Colombia", "Peru", plane4, 150.0, 1.8, "03-12-2025", "10:00");
        
        Airplane plane5 = new Airplane("BASIC-500", 2, 2);
        Flight f5 = new Flight("Mexico", "Japan", plane5, 160.0, 1.9, "10-12-2025", "13:00");

        List<Flight> flights = new ArrayList<>();
        flights.add(f1);
        flights.add(f2);
        flights.add(f3);
        flights.add(f4);
        flights.add(f5);

        String[] options = {"Verify Availability", "Make Reservation", "Show Flights Status", "Exit"};
        while (true) {
            int choice = JOptionPane.showOptionDialog(null,
                    "Airline Reservation \nChoose an action:",
                    "Flight Reservation",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, options, options[0]);

            if (choice == 0) { // Verify availability
                Flight flight = selectFlight(flights);
                if (flight == null) continue;
                Airplane.SeatClass seatClass = selectClass();
                if (seatClass == null) continue;
                boolean avail = flight.checkAvailability(seatClass);
            if (avail) {
               double price = flight.calculatePrice(seatClass);
               String msg = "Seats available for " + seatClass + "\nPrice: $" + price;
               JOptionPane.showMessageDialog(null, flight.getRoute() + "\n" + msg, "Availability", JOptionPane.INFORMATION_MESSAGE);
             } else {
              JOptionPane.showMessageDialog(null, flight.getRoute() + "\nNo seats available for " + seatClass, "Availability", JOptionPane.INFORMATION_MESSAGE);
            }
            } else if (choice == 1) { // Make reservation
                Flight flight = selectFlight(flights);
                if (flight == null)
                    continue;
                Airplane.SeatClass seatClass = selectClass();
                if (seatClass == null) 
                    continue;
                String name = JOptionPane.showInputDialog(null, "Enter passenger full name:");
                if (name == null || name.trim().isEmpty()) { 
                   JOptionPane.showMessageDialog(null, "Name is required."); 
                   continue;
                }
                String id = JOptionPane.showInputDialog(null, "Enter passenger ID:");
                if (id == null || id.trim().isEmpty()) { 
                   JOptionPane.showMessageDialog(null, "ID is required."); 
                   continue; 
                }
                String email = JOptionPane.showInputDialog(null, "Enter passenger email:");
                if (email == null || email.trim().isEmpty()) {
                   JOptionPane.showMessageDialog(null, "Email is required.");
                   continue; 
                }
               String phone = JOptionPane.showInputDialog(null, "Enter passenger phone number:");
               if (phone == null || phone.trim().isEmpty()) {
                  JOptionPane.showMessageDialog(null, "Phone number is required.");
                  continue;
                }

                Passenger p = new Passenger(name.trim(), id.trim(), email.trim(), phone.trim());
                Reservation res = new Reservation(flight, p, seatClass);

                // Verify availability before reserving (requirement)
                if (!flight.checkAvailability(seatClass)) {
                    JOptionPane.showMessageDialog(null, "No availability for selected class.", "Error", JOptionPane.ERROR_MESSAGE);
                    continue;
                }

                boolean ok = res.verifyAndReserve();
                if (!ok) {
                    JOptionPane.showMessageDialog(null, "Reservation failed. Try again.", "Error", JOptionPane.ERROR_MESSAGE);
                    continue;
                }

                // Show ticket and invoice
                Ticket t = res.getTicket();
                Invoice inv = res.getInvoice();
                String out = "=== Ticket ===\n" + t.toString() + "\n\n=== Invoice ===\n" + inv.toString();
                JOptionPane.showMessageDialog(null, out, "Reservation Success", JOptionPane.INFORMATION_MESSAGE);

            } else if (choice == 2) { // Show flights status
                StringBuilder sb = new StringBuilder();
                for (Flight fl : flights) {
                    sb.append(fl.toString()).append("\n");
                }
                JOptionPane.showMessageDialog(null, sb.toString(), "Flights Status", JOptionPane.INFORMATION_MESSAGE);
            } else { // Exit or closed dialog
                break;
            }
        }

        JOptionPane.showMessageDialog(null, "CLOSED.");
        System.exit(0);
    }

    private static Flight selectFlight(List<Flight> flights) {
        String[] flightOptions = new String[flights.size()];
        for (int i = 0; i < flights.size(); i++) {
            flightOptions[i] = i + 1 + ") " + flights.get(i).getRoute();
        }
        String choice = (String) JOptionPane.showInputDialog(null, "Select flight:", "Flights",
                JOptionPane.PLAIN_MESSAGE, null, flightOptions, flightOptions[0]);
        if (choice == null) return null;
        int idx = Integer.parseInt(choice.split("\\)")[0]) - 1;
        return flights.get(idx);
    }

    private static Airplane.SeatClass selectClass() {
        String[] classes = {"Business", "Economy"};
        int c = JOptionPane.showOptionDialog(null, "Select class:", "Class",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, classes, classes[1]);
        if (c == 0) return Airplane.SeatClass.BUSINESS;
        if (c == 1) return Airplane.SeatClass.ECONOMY;
        return null;
    }
    
    }
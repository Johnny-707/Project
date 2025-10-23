package domain;

import java.util.UUID;


public class Reservation {
 private Flight flight;
    private Passenger passenger;
    private Airplane.SeatClass seatClass;
    private Ticket ticket;
    private Invoice invoice;

    public Reservation(Flight flight, Passenger passenger, Airplane.SeatClass seatClass) {
        this.flight = flight;
        this.passenger = passenger;
        this.seatClass = seatClass;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Airplane.SeatClass getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(Airplane.SeatClass seatClass) {
        this.seatClass = seatClass;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    
    public boolean verifyAndReserve() {
        if (!flight.checkAvailability(seatClass)) return false;
        boolean reserved = flight.reserveSeat(seatClass);
        if (!reserved) return false;
        createTicketAndInvoice();
        return true;
    }

    private void createTicketAndInvoice() {
        String ticketNum = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        ticket = new Ticket(ticketNum, flight, passenger, seatClass);
        double price = flight.calculatePrice(seatClass);
        String invoiceNum = "INV-" + UUID.randomUUID().toString().substring(0,6).toUpperCase();
        invoice = new Invoice(invoiceNum, ticket, price);
    }

}
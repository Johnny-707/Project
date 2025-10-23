package domain;


public class Ticket {
private Flight flight;
    private Passenger passenger;
    private Airplane.SeatClass seatClass;
    private String ticketNumber;

    public Ticket(String ticketNumber, Flight flight, Passenger passenger, Airplane.SeatClass seatClass) {
        this.ticketNumber = ticketNumber;
        this.flight = flight;
        this.passenger = passenger;
        this.seatClass = seatClass;
    }

    public String getTicketNumber() { 
        return ticketNumber; 
    }
    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
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
    @Override
    public String toString() {
           return "Ticket#: " + ticketNumber 
                + "\nFlight: " + flight.getRoute() 
                + "\nClass: " + seatClass
                + "\nPassenger: " + passenger.getFullName();
    }

 }
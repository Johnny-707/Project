
package domain;

import java.text.NumberFormat;
import java.util.Locale;

public class Invoice {
    private String invoiceNumber;
    private Ticket ticket;
    private double price;

    public Invoice(String invoiceNumber, Ticket ticket, double price) {
        this.invoiceNumber = invoiceNumber;
        this.ticket = ticket;
        this.price = price;
    }
   public String getInvoiceNumber() {
        return invoiceNumber; 
    }
   
    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }
   public Ticket getTicket() { 
        return ticket; 
    }
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
   public double getPrice() { 
        return price; 
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public String formattedPrice() {
        NumberFormat fmt = NumberFormat.getCurrencyInstance(Locale.getDefault());
        return fmt.format(price);
    }

    @Override
    public String toString() {
           return "Invoice#: " + invoiceNumber 
                + "\nFlight: " + ticket.getFlight().getRoute()
                + "\nPassenger: " + ticket.getPassenger().getFullName()
                + "\nID Number: " + ticket.getPassenger().getIdNumber()
                +"\nEmail: " + ticket.getPassenger().getEmail()
                +"\nPhone Number: " + ticket.getPassenger().getPhoneNumber()   
                + "\nPrice: " + formattedPrice();
    }
}

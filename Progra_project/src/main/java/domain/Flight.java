<<<<<<< HEAD
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author luzma
 */
public class Flight {
  private String origin;
  private String destination;
  private Airplane airplane;
  private double basePriceEconomy; 
  private double businessMultiplier; 
  private String date;
  private String boardingTime;
    
  public Flight(String origin, String destination, Airplane airplane, double basePriceEconomy, double businessMultiplier, String date, String boardingTime) {
    this.origin = origin;
    this.destination = destination;
    this.airplane = airplane;
    this.basePriceEconomy = basePriceEconomy;
    this.businessMultiplier = businessMultiplier;
    this.date = date;
    this.boardingTime = boardingTime;
=======
package domain;


public class Flight {
    private String origin;
    private String destination;
    private Airplane airplane;
    private double basePriceEconomy; // base price for economy
    private double businessMultiplier; // multiplier for business
    private String date;
    private String boardingTime;
    
    public Flight(String origin, String destination, Airplane airplane, double basePriceEconomy, double businessMultiplier, String date, String boardingTime) {
        this.origin = origin;
        this.destination = destination;
        this.airplane = airplane;
        this.basePriceEconomy = basePriceEconomy;
        this.businessMultiplier = businessMultiplier;
        this.date = date;
        this.boardingTime = boardingTime;
>>>>>>> af77db3 (Reser and ticket)
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getBasePriceEconomy() {
        return basePriceEconomy;
    }

    public void setBasePriceEconomy(double basePriceEconomy) {
        this.basePriceEconomy = basePriceEconomy;
    }

    public double getBusinessMultiplier() {
        return businessMultiplier;
    }

    public void setBusinessMultiplier(double businessMultiplier) {
        this.businessMultiplier = businessMultiplier;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBoardingTime() {
        return boardingTime;
    }

    public void setTime(String boardingTime) {
        this.boardingTime = boardingTime;
    }

    public boolean checkAvailability(Airplane.SeatClass seatClass) {
        return airplane.hasAvailability(seatClass);
    }

    public boolean reserveSeat(Airplane.SeatClass seatClass) {
        return airplane.reserveSeat(seatClass);
    }

    public String getRoute() {
        return origin + " -> " + destination + " -> " + date + " -> " + boardingTime;
    }

    public double calculatePrice(Airplane.SeatClass seatClass) {
        if (seatClass == Airplane.SeatClass.ECONOMY) return basePriceEconomy;
        else return basePriceEconomy * businessMultiplier;
    }

    public Airplane getAirplane() { 
        return airplane; }

    @Override
    public String toString() {
        return getRoute() + " | " + airplane.toString();
<<<<<<< HEAD
    }    
}
=======
    }
 
 
}
>>>>>>> af77db3 (Reser and ticket)

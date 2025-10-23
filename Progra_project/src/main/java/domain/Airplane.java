/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author luzma
 */
public class Airplane {
  private String model;
  private Map<SeatClass, Integer> capacity;
  private Map<SeatClass, Integer> booked;

  public enum SeatClass { BUSINESS, ECONOMY }

  public Airplane(String model, int execCapacity, int ecoCapacity) {
      this.model = model;
      capacity = new HashMap<>();
      booked = new HashMap<>();
      capacity.put(SeatClass.BUSINESS, execCapacity);
      capacity.put(SeatClass.ECONOMY, ecoCapacity);
      booked.put(SeatClass.BUSINESS, 0);
      booked.put(SeatClass.ECONOMY, 0);
    }

    public Map<SeatClass, Integer> getCapacity() {
        return capacity;
    }

    public void setCapacity(Map<SeatClass, Integer> capacity) {
        this.capacity = capacity;
    }

    public Map<SeatClass, Integer> getBooked() {
        return booked;
    }

    public void setBooked(Map<SeatClass, Integer> booked) {
        this.booked = booked;
    }

    public String getModel() { 
        return model; }

    public boolean hasAvailability(SeatClass seatClass) {
        return booked.get(seatClass) < capacity.get(seatClass);
    }

    public boolean reserveSeat(SeatClass seatClass) {
        if (!hasAvailability(seatClass)) return false;
        booked.put(seatClass, booked.get(seatClass) + 1);
        return true;
    }

    public int getCapacity(SeatClass seatClass) {
        return capacity.get(seatClass);
    }

    public int getBooked(SeatClass seatClass) {
        return booked.get(seatClass);
    }

    @Override
    public String toString() {
        return model + " (Business: " + booked.get(SeatClass.BUSINESS) + "/" + capacity.get(SeatClass.BUSINESS)
                + " , Ecoomy: " + booked.get(SeatClass.ECONOMY) + "/" + capacity.get(SeatClass.ECONOMY) + ")";
    }   
}

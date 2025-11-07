package domain;


public class Passenger {
    private String fullName;
    private String idNumber;
    private String email;
    private String phoneNumber;
    

    public Passenger(String fullName, String idNumber, String email, String phoneNumber) {
        this.fullName = fullName;
        this.idNumber = idNumber;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getFullName() { 
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    public String getIdNumber() { 
        return idNumber; 
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    

    @Override
    public String toString() {
        return "\nPassenger: " + getFullName()
              +"\nID Number: " + getIdNumber()
              +"\nEmail: " + getEmail()
              +"\nPhone Number: " + getPhoneNumber();
    }

}
package za.ac.cput.domain.impl;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;
import za.ac.cput.domain.IDomain;
import za.ac.cput.domain.IRent;

/**
 * Lonwabo Magazi-218331851
 * Date: March 2023
 * Rental Class.java
 */


@Entity
public class Rental implements IRent {
    //Declare the private variables

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rentalId;
    //users rent cars ,

    // Define the relationships
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "carId")
    private Car car;


    private String issuer;
    private String issuedDate;
    private String Date;
    private String dateReturned;
    private String receiver;
    private boolean finePaid;


    //Initializing a parameterized constructor
    public Rental(int rentalId, Car car,  String issuer, String issuedDate, String Date, String DateReturned, String receiver, boolean fine) {

        this.rentalId = rentalId;
        this.car = car;


        this.issuer = issuer;
        this.issuedDate = issuedDate;
        this.Date = Date;
        this.dateReturned = DateReturned;
        this.receiver = receiver;
        this.finePaid = fine;
    }


    private Rental(RentalBuilder builder) {

        this.rentalId = builder.rentalId;
        this.issuer = builder.issuer;
        this.Date = builder.Date;
        this.issuedDate = builder.dateReturned;
        this.dateReturned = builder.receiver;
        this.finePaid = builder.finePaid;

    }

    public Rental() {

    }

    public int getRentalId() {
        return this.rentalId;
    }



    @Override
    public int getId() {
        return 0;
    }

    @Override
    public int getBorrower() {
        return 0;
    }


    public String getIssuer() {
        return issuer;
    }

    public String getIssuedDate() {
        return issuedDate;
    }

    @Override
    public String getDate() {
        return null;
    }

    public String getDateReturned() {
        return dateReturned;
    }

    public String getReceiver() {
        return receiver;
    }

    @Override
    public boolean finePaid() {
        return false;
    }

    public boolean isFinePaid() {
        return finePaid;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "rentalId=" + rentalId +


                ", issuer='" + issuer + '\'' +
                ", issuedDate='" + issuedDate + '\'' +
                ", dateReturned='" + dateReturned + '\'' +
                ", receiver='" + receiver + '\'' +
                ", finePaid=" + finePaid +
                '}';
    }

    public User getUser() {
        return user;

    }

    public Car getCar() {
        return car;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public void setCar(Car car) {
        this.car = car;
    }

    //Builder Class
    public static class RentalBuilder {

        private int rentalId;
        private int userId;
        private int carId;
        private String issuer;

        private String Date;
        private String issuedDate;
        private String dateReturned;
        private String receiver;
        private boolean finePaid;


        public Rental.RentalBuilder setRentalId(int rentalId) {
            this.rentalId = rentalId;
            return this;
        }

        public Rental.RentalBuilder setBorrower(int userId) {
            this.userId = userId;
            return this;
        }

        public Rental.RentalBuilder setCar(int carId) {
            this.carId = carId;
            return this;
        }

        public Rental.RentalBuilder setIssuer(String issuer) {
            this.issuer = issuer;
            return this;
        }

        public Rental.RentalBuilder setDate(String Date) {
            this.Date = Date;
            return this;
        }

        public Rental.RentalBuilder setIssuedDate(String issuedDate) {
            this.issuedDate = issuedDate;
            return this;
        }

        public Rental.RentalBuilder setDateReturned(String dateReturned) {
            this.dateReturned = dateReturned;
            return this;
        }

        public Rental.RentalBuilder setReceiver(String receiver) {
            this.receiver = receiver;
            return this;
        }

        public Rental.RentalBuilder setFinePaid(Boolean finePaid) {
            this.finePaid = finePaid;
            return this;
        }

        public Rental build() {
            return new Rental(this);
        }
    }
}
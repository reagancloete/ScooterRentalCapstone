/**
 * ScooterType.java
 * Entity for the ScooterType
 * @author: Siyabulela Tshitshi (219229716)
 * Date: 17 May 2023
 */

package za.ac.cput.domain;

import jakarta.persistence.*;

@Entity
public class ScooterType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String scooterDescription;
    private int capacity;
    private double rentalPrice;

    public ScooterType(){}

    private ScooterType(Builder builder){
        this.scooterDescription = builder.scooterDescription;
        this.capacity = builder.capacity;
        this.rentalPrice = builder.rentalPrice;
    }

    public Long getId() {
        return id;
    }

    public String getScooterDescription() {
        return scooterDescription;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public void setScooterDescription(String scooterDescription) {
        this.scooterDescription = scooterDescription;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    @Override
    public String toString() {
        return "ScooterType{" +
                "id=" + id +
                ", scooterDescription='" + scooterDescription + '\'' +
                ", capacity=" + capacity +
                ", rentalPrice=" + rentalPrice +
                '}';
    }

    public static class Builder{
        private String scooterDescription;
        private int capacity;
        private double rentalPrice;

        public Builder setScooterDescription(String scooterDescription) {
            this.scooterDescription = scooterDescription;
            return this;
        }

        public Builder setCapacity(int capacity) {
            this.capacity = capacity;
            return this;
        }

        public Builder setRentalPrice(double rentalPrice) {
            this.rentalPrice = rentalPrice;
            return this;
        }

        public Builder copy(ScooterType scooterType){
            this.scooterDescription = scooterType.scooterDescription;
            this.capacity = scooterType.capacity;
            this.rentalPrice = scooterType.rentalPrice;
            return this;
        }

        public ScooterType build(){
            return new ScooterType(this);
        }
    }
}

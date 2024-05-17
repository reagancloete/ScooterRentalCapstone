/**
 * Scooter.java
 * Entity for the Scooter
 * @autor: Siyabulela Tshitshi (219229716)
 * Date: 17 may 2024
 */
package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Scooter {
    @Id
    private String numberPlate;
    private String scooterMake;
    private String scooterColor;
    private String year;
    private String scooterName;

    @ManyToOne
    @JoinColumn(name = "scooterType_id")
    private ScooterType scooterType;

    public Scooter(){}

    //builder constructor
    private Scooter(Builder builder){
        this.numberPlate = builder.numberPlate;
        this.scooterMake = builder.scooterMake;
        this.scooterColor = builder.scooterColor;
        this.year = builder.year;
        this.scooterName = builder.scooterName;
        this.scooterType = builder.scooterType;
    }

    public String getScooterMake() {
        return scooterMake;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public String getScooterColor() {
        return scooterColor;
    }

    public String getYear() {
        return year;
    }

    public String getScooterName() {
        return scooterName;
    }

    public ScooterType getScooterType() {
        return scooterType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scooter scooter = (Scooter) o;
        return numberPlate.equals(scooter.numberPlate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberPlate);
    }

    @Override
    public String toString() {
        return "Scooter{" +
                "numberPlate='" + numberPlate + '\'' +
                ", scooterMake='" + scooterMake + '\'' +
                ", scooterColor='" + scooterColor + '\'' +
                ", year='" + year + '\'' +
                ", scooterName='" + scooterName + '\'' +
                ", scooterType=" + scooterType +
                '}';
    }

    public static class Builder{
        private String numberPlate;
        private String scooterMake;
        private String scooterColor;
        private String year;
        private String scooterName;
        private ScooterType scooterType;

        public Builder setNumberPlate(String numberPlate) {
            this.numberPlate = numberPlate;
            return this;
        }
        public Builder setScooterMake(String scooterMake) {
            this.scooterMake = scooterMake;
            return this;
        }
        public Builder setScooterColor(String scooterColor) {
            this.scooterColor = scooterColor;
            return this;
        }
        public Builder setYear(String year) {
            this.year = year;
            return this;
        }
        public Builder setScooterName(String scooterName) {
            this.scooterName = scooterName;
            return this;
        }

        public Builder setScooterType(ScooterType scooterType) {
            this.scooterType = scooterType;
            return this;
        }

        public Builder copy(Scooter scooter){
            this.numberPlate = scooter.numberPlate;
            this.scooterMake = scooter.scooterMake;
            this.scooterColor = scooter.scooterColor;
            this.year = scooter.year;
            this.scooterName = scooter.scooterName;
            this.scooterType = scooter.scooterType;
            return this;
        }

        public Scooter build(){
            return new Scooter(this);
        }
    }
}

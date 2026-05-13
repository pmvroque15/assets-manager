package com.pluralsight;

import java.time.LocalDate;

public class Vehicle extends Asset{
    private String makeModel;
    private int year;
    private int odometer;

    public Vehicle(String description, String dateAcquired, double originalCost, String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }
    
    @Override
    public double getValue() {
        int currentYear = LocalDate.now().getYear();
        int carAge = currentYear - this.year;
        double value = super.getOriginalCost();
        
        if(carAge >= 0 && carAge <= 3) {
            value -= value * (1 - (0.03 * carAge));
        } else if (carAge <= 6) {
            value -= value * (1 - (0.06 * carAge));
        } else if (carAge <= 10) {
            value -= value * (1 - (0.08 * carAge));
        }

        if (carAge > 10) {
            value -= value - 1000;

        }

            if(!this.makeModel.equalsIgnoreCase("Honda") && !this.makeModel.equalsIgnoreCase("Toyota")) {
               if (this.odometer >= 100000) {
                    value *= 0.75;
                }
            }


        return value;
    }
}

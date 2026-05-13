package com.pluralsight;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Asset> assets = new ArrayList<>();

        Asset house = new House("Condo", "2026", 8000000, "123 Main Street", 1, 8000, 214324);
        assets.add(house);

        Asset car = new Vehicle("Black, good condition, sports car", "2021", 123455, "Mazda", 2019, 120000);
        assets.add(car);

        for (Asset a : assets) {

            if (a instanceof  House) {
                System.out.printf("ASSET: %s | DATE ACQUIRED: %s | ADDRESS: %s | VALUE: $%,.2f%n", a.getDescription(), ((House) a).getAddress(), a.getOriginalCost(), a.getValue());
            }

            if (a instanceof Vehicle) {
                System.out.printf("ASSET: %s | MAKE & MODEL: %s | ORIGINAL COST: $%,.2f | VALUE: $%,.2f%n", a.getDescription(), ((Vehicle) a).getMakeModel(), a.getOriginalCost(), a.getValue());
            }
        }
    }

}
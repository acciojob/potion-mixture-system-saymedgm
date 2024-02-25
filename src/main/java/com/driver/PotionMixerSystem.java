package com.driver;

import java.util.Scanner;

public class PotionMixerSystem {

    public static class Potion {
        private final String potionName;
        private final String mainIngredient;
        private final String additiveIngredient;
        private double power;

        public Potion(String potionName, String mainIngredient, String additiveIngredient) {
            this.potionName = potionName;
            this.mainIngredient = mainIngredient;
            this.additiveIngredient = additiveIngredient;
            this.calculatePower();
        }

        public void calculatePower() {
            double basePower = 0.0;

            if ("Rose".equals(mainIngredient)) {
                basePower = 100.0;
            } else if ("Lavender".equals(mainIngredient)) {
                basePower = 80.0;
            } else if ("Mint".equals(mainIngredient)) {
                basePower = 60.0;
            }

            double percentageBoost = 0.0;

            if ("Honey".equals(additiveIngredient)) {
                percentageBoost = 0.20;
            } else if ("Ginger".equals(additiveIngredient)) {
                percentageBoost = 0.10;
            } else if ("Lemon".equals(additiveIngredient)) {
                percentageBoost = 0.05;
            }

            this.power = basePower + (basePower * percentageBoost);

            if (this.power > 500) {
                this.power = 500; // Caps the power to a maximum of 500
            }
        }

        public String getPotionName() {
            return potionName;
        }

        public String getMainIngredient() {
            return mainIngredient;
        }

        public String getAdditiveIngredient() {
            return additiveIngredient;
        }

        public double getPower() {
            return power;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter potion name: ");
        String potionName = scanner.nextLine();

        System.out.print("Enter main ingredient (Rose, Lavender, Mint): ");
        String mainIngredient = scanner.nextLine();

        System.out.print("Enter additive ingredient (Honey, Ginger, Lemon): ");
        String additiveIngredient = scanner.nextLine();

        Potion potion = new Potion(potionName, mainIngredient, additiveIngredient);

        System.out.println("Potion Details:");
        System.out.println("Name: " + potion.getPotionName());
        System.out.println("Main Ingredient: " + potion.getMainIngredient());
        System.out.println("Additive Ingredient: " + potion.getAdditiveIngredient());
        System.out.println("Power: " + potion.getPower());
    }
}
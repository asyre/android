package ru.ifmo.task10;

public class MoneyConverter {
    private double euroToRubliRate = 71.50, dollarToRubliRate = 65.08, juanToRubliRate = 9.12;

    public double convertFromRubli(double money, String currency) {
        switch (currency.toLowerCase()) {
            case "euro":
            case "€":
            case "евро":
                return money / euroToRubliRate;
            case "dollar":
            case "$":
            case "доллар":
                return money / dollarToRubliRate;
            case "juan":
            case "¥":
            case "юань":
                return money / juanToRubliRate;
            default:
                System.out.println("Such currency is not supported.");

        }
        return 0;
    }

    public double convertToRubli(double money, String currency) {
        switch (currency.toLowerCase()) {
            case "euro":
            case "€":
            case "евро":
                return money * euroToRubliRate;
            case "dollar":
            case "$":
            case "доллар":
                return money * dollarToRubliRate;
            case "juan":
            case "¥":
            case "юань":
                return money * juanToRubliRate;
            default:
                System.out.println("Such currency is not supported.");

        }
        return 0;
    }
}

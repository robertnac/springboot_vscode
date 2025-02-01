package de.ronasoft.springboot.vscode.decorate;

public class Main {
    public static void main(String[] args) {

// Verwendung
        Coffee myCoffee = new MilkDecorator(new BasicCoffee());
        System.out.println(myCoffee.getDescription()); // "Kaffee, Milch"
        System.out.println(myCoffee.getCost());        // 2.00
    }
}

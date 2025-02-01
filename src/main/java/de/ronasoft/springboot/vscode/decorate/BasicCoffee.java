package de.ronasoft.springboot.vscode.decorate;

// Concrete Component
class BasicCoffee implements Coffee {
    public String getDescription() {
        return "Kaffee";
    }

    public double getCost() {
        return 1.50;
    }
}

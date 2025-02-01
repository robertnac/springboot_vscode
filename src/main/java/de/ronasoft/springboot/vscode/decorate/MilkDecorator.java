package de.ronasoft.springboot.vscode.decorate;

// Concrete Decorator: Milch
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Milch";
    }

    public double getCost() {
        return decoratedCoffee.getCost() + 0.50;
    }
}

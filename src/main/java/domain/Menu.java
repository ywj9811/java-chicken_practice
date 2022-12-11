package domain;

public class Menu {
    private final int number;
    private final String name;
    private final Category category;
    private final int price;
    private int quantity;

    public void setQuantity(int quantity) {
        this.quantity += quantity;
    }

    public void resetQuantity() {
        this.quantity = 0;
    }

    public int getQuantity() {
        return quantity;
    }
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Menu(final int number, final String name, final Category category, final int price) {
        this.number = number;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public String toString() {
        return category + " " + number + " - " + name + " : " + price + "원";
    }
}

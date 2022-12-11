package domain;

public class TablePrice {
    private final int table;
    private int price;


    public TablePrice(int table, int price) {
        this.price = price;
        this.table = table;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int plusPrice) {
        price += plusPrice;
    }
}

package domain;

import java.util.ArrayList;
import java.util.List;

public class TablePriceRepository {
    private static final List<TablePrice> tablePrices = new ArrayList<>();

    static {
        tablePrices.add(new TablePrice(1));
        tablePrices.add(new TablePrice(2));
        tablePrices.add(new TablePrice(3));
        tablePrices.add(new TablePrice(4));
        tablePrices.add(new TablePrice(5));
        tablePrices.add(new TablePrice(6));
        tablePrices.add(new TablePrice(8));
    }

    public static List<TablePrice> getTablePrices() {
        return tablePrices;
    }

}

package domain;

import java.util.ArrayList;
import java.util.List;

public class TablePriceRepository {
    private static final List<TablePrice> tablePrices = new ArrayList<>();

    static {
        tablePrices.add(new TablePrice(1, 0));
        tablePrices.add(new TablePrice(2, 0));
        tablePrices.add(new TablePrice(3, 0));
        tablePrices.add(new TablePrice(4, 0));
        tablePrices.add(new TablePrice(5, 0));
        tablePrices.add(new TablePrice(6, 0));
        tablePrices.add(new TablePrice(8, 0));
    }

    public static List<TablePrice> getTablePrices() {
        return tablePrices;
    }

}

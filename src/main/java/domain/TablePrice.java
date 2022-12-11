package domain;

import java.util.ArrayList;
import java.util.List;

public class TablePrice {
    private final int table;

    private static List<Menu> menus = MenuRepository.menus();

    public TablePrice(int table) {
        this.table = table;
    }
    public List<Menu> getMenus() {
        return menus;
    }

    public void resetMenus() {
        for (Menu menu : menus) {
            menu.resetQuantity();
        }
    }

    public void setMenuQuantity(int menuNumber, int quantity) {
        if (menuNumber < 7) {
            menus.get(menuNumber - 1).setQuantity(quantity);
            return;
        }
        menus.get(menuNumber - 15).setQuantity(quantity);
        return;
    }

}

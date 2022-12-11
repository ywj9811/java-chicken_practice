package domain;

import java.util.List;

public class TablePrice {
    MenuRepository menuRepository = new MenuRepository();
    private final int table;
    private int order;

    private List<Menu> menus = menuRepository.menus();

    public TablePrice(int table, int order) {
        this.table = table;
        this.order = order;
    }

    public int getOrder(){
        return order;
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

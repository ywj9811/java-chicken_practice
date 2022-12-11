package service;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class OrderService {
    private MenuRepository menuRepository = new MenuRepository();
    private final List<Table> tables = TableRepository.tables();
    private final List<Menu> menus = menuRepository.menus();
    private int tableNumber;
    private int menuNumber;
    private int menuCount;

    private List<TablePrice> tablePrices = TablePriceRepository.getTablePrices();

    public void orderFunction() {
        OutputView.printTables(tables);
        tableNumber = InputView.inputTableNumber();
        OutputView.printMenus(menus);
        menuNumber = InputView.inputMenuNumber();
        menuCount = InputView.menuCount();
        orderWithTableNumber();
    }

    private void orderWithTableNumber() {
        if (tableNumber < 5) {
            settingPriceAndQuantity(tableNumber - 1);
            return;
        }
        if (tableNumber < 8) {
            settingPriceAndQuantity(tableNumber - 2);
            return;
        }
        settingPriceAndQuantity(tableNumber - 3);
    }

    private void settingPriceAndQuantity(int listIndex) {
        tablePrices.get(listIndex).setOrder(1);
        tablePrices.get(listIndex).setMenuQuantity(menuNumber, menuCount);
    }
}

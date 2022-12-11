package service;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class OrderService {
    private final List<Table> tables = TableRepository.tables();
    private final List<Menu> menus = MenuRepository.menus();
    private int tableNumber;
    private int menuNumber;
    private int menuCount;
    private int price;
    private List<TablePrice> tablePrices = TablePriceRepository.getTablePrices();


    public void whatFunction() {
        int number = InputView.wantFunction();
        if (number == 1) {
            orderFunction();
            whatFunction();
        }
        if (number == 2) {
            whatFunction();
        }
        if (number == 3) {
            return;
        }
    }

    public void payFunction() {

    }

    public void orderFunction() {
        OutputView.printTables(tables);
        tableNumber = InputView.inputTableNumber();
        OutputView.printMenus(menus);
        menuNumber = InputView.inputMenuNumber();
        menuCount = InputView.menuCount();
        if (tableNumber < 7) {
            tablePrices.get(tableNumber - 1).setMenuQuantity(menuNumber, menuCount);
            return;
        }
        tablePrices.get(tableNumber - 2).setMenuQuantity(menuNumber, menuCount);
    }
}

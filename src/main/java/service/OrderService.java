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


    public void whatFunction() {
        OutputView.printStart();
        int number = InputView.wantFunction();
        if (number == 1) {
            orderFunction();
            whatFunction();
        }
        if (number == 2) {
            payFunction();
            whatFunction();
        }
        if (number == 3) {
            return;
        }
    }

    public void payFunction() {
        OutputView.printTables(tables);
        tableNumber = InputView.inputTableNumber();
        int totalPay;
        if (tableNumber < 7) {
            totalPay = OutputView.printTotalPay(tablePrices.get(tableNumber - 1), tableNumber);
            tablePrices.get(tableNumber - 1).resetMenus();
            tablePrices.set(tableNumber - 1, new TablePrice(tableNumber - 1, 0));
        } else {
            totalPay = OutputView.printTotalPay(tablePrices.get(tableNumber - 2), tableNumber);
            tablePrices.get(tableNumber - 2).resetMenus();
            tablePrices.set(tableNumber - 1, new TablePrice(tableNumber - 2, 0));
        }
        int payNumber = InputView.inputPayNumber();
        if (payNumber == 1) {
            OutputView.printPay(totalPay);
            return;
        }
        OutputView.printPay((int) (totalPay*(0.95)));
    }

    public void orderFunction() {
        OutputView.printTables(tables);
        tableNumber = InputView.inputTableNumber();
        OutputView.printMenus(menus);
        menuNumber = InputView.inputMenuNumber();
        menuCount = InputView.menuCount();
        if (tableNumber < 7) {
            tablePrices.get(tableNumber - 1).setMenuQuantity(menuNumber, menuCount);
            tablePrices.set(tableNumber - 1, new TablePrice(tableNumber - 1, 1));
            return;
        }
        tablePrices.get(tableNumber - 2).setMenuQuantity(menuNumber, menuCount);
        tablePrices.set(tableNumber - 2, new TablePrice(tableNumber - 2, 1));
    }
}

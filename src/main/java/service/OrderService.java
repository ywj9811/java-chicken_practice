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
    private int totalPay;

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
        if (number == 3)
            return;
    }

    private void payFunction() {
        OutputView.printTables(tables);
        tableNumber = InputView.inputTableNumber();
        payWithTableNumber(tableNumber);
        int payNumber = InputView.inputPayNumber();
        if (payNumber == 1) {
            OutputView.printPay(totalPay);
            return;
        }
        OutputView.printPay((int) (totalPay*(0.95)));
    }

    private void payWithTableNumber(int tableNumber) {
        if (tableNumber < 5) {
            outputWithTotalPay(tableNumber - 1);
            return;
        }
        if (tableNumber < 8) {
            outputWithTotalPay(tableNumber - 2);
            return;
        }
        outputWithTotalPay(tableNumber - 3);
    }

    private void outputWithTotalPay(int tableNumber) {
        totalPay = OutputView.printTotalPay(tablePrices.get(tableNumber), tableNumber);
        tablePrices.get(tableNumber).resetMenus();
        tablePrices.get(tableNumber).setOrder(0);
    }

    private void orderFunction() {
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

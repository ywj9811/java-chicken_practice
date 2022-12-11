package service;

import controller.TotalController;
import domain.Table;
import domain.TablePrice;
import domain.TablePriceRepository;
import validation.InputValidation;
import view.InputView;
import view.OutputView;

import java.util.List;

public class PayService {
    private List<TablePrice> tablePrices;
    private final List<Table> tables;
    private int tableNumber;
    private int totalPay;

    public PayService(List<Table> tables, List<TablePrice> tablePrices) {
        this.tables = tables;
        this.tablePrices = tablePrices;
    }

    public void payFunction() {
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
        TotalController totalController = new TotalController();

        try {
            totalPay = OutputView.printTotalPay(tablePrices.get(tableNumber), tableNumber);
            tablePrices.get(tableNumber).resetMenus();
            tablePrices.get(tableNumber).setOrder(0);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            totalController.whatFunction();
            return;
        }
    }
}

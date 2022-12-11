package controller;

import domain.*;
import service.OrderService;
import service.PayService;
import validation.InputValidation;
import view.InputView;
import view.OutputView;

import java.util.List;

public class TotalController {
    private final List<Table> tables = TableRepository.tables();
    private List<TablePrice> tablePrices = TablePriceRepository.getTablePrices();
    private OrderService orderService = new OrderService();
    private PayService payService = new PayService(tables, tablePrices);
    private InputValidation validation = new InputValidation();

    public void whatFunction() {
        OutputView.printStart();
        int number = InputView.wantFunction();
        inputValidation(number);
        if (number == 1) {
            orderService.orderFunction();
            whatFunction();
        }
        if (number == 2) {
            payService.payFunction();
            whatFunction();
        }
        if (number == 3)
            return;
    }

    public void inputValidation(int number) {
        try {
            validation.notNumberInRange(number);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            whatFunction();
        }
    }
}

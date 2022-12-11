package controller;

import domain.*;
import service.OrderService;
import service.PayService;
import view.InputView;
import view.OutputView;

import java.util.List;

public class TotalController {
    private final List<Table> tables = TableRepository.tables();
    private List<TablePrice> tablePrices = TablePriceRepository.getTablePrices();
    private OrderService orderService = new OrderService();
    private PayService payService = new PayService(tables, tablePrices);

    public void whatFunction() {
        OutputView.printStart();
        int number = InputView.wantFunction();
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
}

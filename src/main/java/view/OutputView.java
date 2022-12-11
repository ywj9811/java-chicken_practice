package view;

import domain.Menu;
import domain.Table;
import domain.TablePrice;
import domain.TablePriceRepository;

import java.util.List;

public class OutputView {

    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String ORDER_BOTTOM_LINE = "└ # ┘";

    public static void printStart() {
        System.out.println("## 메인화면");
        System.out.println("1 - 주문등록");
        System.out.println("2 - 결제하기");
        System.out.println("3 - 프로그램 종료");
    }

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printLine(BOTTOM_LINE, size);
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    private static void printLine(final String line, final int count) {
        List<TablePrice> tablePrices = TablePriceRepository.getTablePrices();

        for (int index = 0; index < count; index++) {
            if (tablePrices.get(index).getOrder() == 1) {
                System.out.print(ORDER_BOTTOM_LINE);
                continue;
            }
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    public static int printTotalPay(TablePrice tablePrice, int tableNumber) {
        List<Menu> menus = tablePrice.getMenus();
        int totalPay = 0;
        System.out.println("## 주문 내역");
        System.out.println("메뉴 수량 금액");
        for (Menu menu : menus) {
            if (menu.getQuantity() > 0) {
                System.out.println(menu.getName() + " " + menu.getQuantity() + " " + menu.getPrice());
                totalPay += menu.getPrice()*menu.getQuantity();
            }
        }
        System.out.println("## " + tableNumber + "번 테이블의 결제를 진행합니다.");
        return totalPay;
    }

    public static void printPay(int totalPay) {
        System.out.println("## 최종 결제할 금액");
        System.out.println(totalPay + "원");
    }
}

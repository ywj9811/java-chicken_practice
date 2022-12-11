package validation;

import domain.TablePrice;

import java.util.List;

public class InputValidation {

    public void notNumberInRange(int choice) {
        if (!(choice == 1 || choice == 2 || choice == 3)) {
            throw new IllegalArgumentException("[ERROR] 숫자를 다시 입력해 주세요.");
        }
    }

    public void notNumberOfTable(int number) {
        if (!(number == 1 || number == 2 || number == 3 || number == 5
        || number == 6 || number == 8))
            throw new IllegalArgumentException("[ERROR] 테이블 번호를 확인해 주세요.");
    }

    public void notOrderTable(int price) {
        if (price == 0) {
            throw new IllegalArgumentException("[ERROR] 주문을 확인해 주세요.");
        }
    }
}
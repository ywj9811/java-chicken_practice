import controller.TotalController;
import service.OrderService;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        try {
            TotalController totalController = new TotalController();
            totalController.whatFunction();
        } catch (Exception e) {
            return;
        }
    }
}

import java.util.HashMap;
import java.util.Map;

public class Orders implements Printable {
    private Map<Integer, Map<Integer, Integer>> orderList = new HashMap<>();
    private Storage storage;

    public Orders(Storage storage) {
        this.storage = storage;
    }

    public void getBasket(Map<Integer, Integer> basketList) {
        System.out.println("Корзина оплачена!");
        if (orderList.isEmpty()) {
            orderList.put(1, new HashMap<>(basketList));
        } else {
            orderList.put(orderList.keySet().size() + 1, new HashMap<>(basketList));
        }
    }

    @Override
    public void printAll() {
        if (!orderList.isEmpty()) {
            System.out.println("Оплаченные заказы: ");
            for (int orderId : orderList.keySet()) {
                System.out.println("Заказ " + orderId);
                int sum = 0;
                for (int productId : orderList.get(orderId).keySet()) {
                    Product product = storage.getProductById(productId);
                    int amountProduct = orderList.get(orderId).get(productId);
                    sum += amountProduct * product.getPrice();
                    System.out.printf("{ товар= %s, количество= %d, сумма= %d }\n",
                            product.getName(), amountProduct, product.getPrice() * amountProduct);
                }
                System.out.println("Итого: " + sum);
            }
        } else {
            System.out.println("Нет оплаченных заказов!");
        }
    }
}


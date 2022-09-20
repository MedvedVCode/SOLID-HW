import java.util.HashMap;
import java.util.Map;

public class Basket implements Printable {
    private Map<Integer, Integer> basketList = new HashMap<>();
    private Storage storage;

    public Basket(Storage storage) {
        this.storage = storage;
    }

    public boolean isBasketEmpty() {
        if (basketList.isEmpty()) {
            System.out.println("Корзина покупок пуста!");
            return true;
        } else {
            return false;
        }
    }

    public void addProductToBasket(Integer productId, Integer amount) {
        if (basketList.containsKey(productId)) {
            basketList.put(productId, basketList.get(productId) + amount);
        } else {
            basketList.put(productId, amount);
        }
    }

    public void clearBasket() {
        System.out.println("Корзина покупок очищена!");
        basketList.clear();
    }

    @Override
    public void printAll() {
        System.out.println("Корзина:");
        for (int id : basketList.keySet()) {
            Product product = storage.getProductById(id);
            System.out.printf("{ id= %d, товар= %s, цена= %d, количество= %d, сумма= %d }\n",
                    id, product.getName(), product.getPrice(),
                    basketList.get(id), product.getPrice() * basketList.get(id));
        }
    }

    public Map<Integer, Integer> getBasketList() {
        return basketList;
    }
}

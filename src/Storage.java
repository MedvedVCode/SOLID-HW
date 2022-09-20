import java.util.List;
import java.util.Map;

public class Storage implements Printable {
    private List<Product> productList;

    public Storage(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public void printAll() {
        System.out.println("Склад:");
        productList.forEach(System.out::println);
    }

    public int getFirstId() {
        return productList.get(0).getProductId();
    }

    public int getLastId() {
        return productList.size();
    }

    public int getRemainsById(int productId) {
        for (Product product : productList) {
            if (product.getProductId() == productId) {
                return product.getRemains();
            }
        }
        return -1;
    }

    public Product getProductById(int id) {
        for (Product product : productList) {
            if (product.getProductId() == id) {
                return product;
            }
        }
        return null;
    }

    public void update(Map<Integer, Integer> basketList) {
        for (int id : basketList.keySet()) {
            getProductById(id).setRemains(basketList.get(id));
        }
    }
}

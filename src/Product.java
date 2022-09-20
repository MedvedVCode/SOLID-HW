public class Product {
    private int productId;
    private String name;
    private int price;
    private int remains;

    public Product(int productId, String name, int price, int remains) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.remains = remains;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getRemains() {
        return remains;
    }

    public void setRemains(int remains) {
        this.remains -= remains;
    }

    public int getProductId() {
        return productId;
    }

    @Override
    public String toString() {
        return "{" +
                " id= " + productId +
                ", товар= '" + name + '\'' +
                ", цена= " + price +
                ", осталось= " + remains +
                " }";
    }
}

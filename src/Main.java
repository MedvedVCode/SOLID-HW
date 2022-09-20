import java.util.*;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static String readScanner;
    public static Basket basket;
    public static Storage storage;
    public static Orders orders;

    public static void main(String[] args) {
        storage = new Storage(
                new ArrayList<>(
                        List.of(
                                new Product(1, "Ноутбук", 80000, 10),
                                new Product(2, "Планшет", 30000, 13),
                                new Product(3, "Мышь", 800, 14),
                                new Product(4, "Клавиатура", 2000, 12),
                                new Product(5, "Смартфон", 60000, 16),
                                new Product(6, "Зарядка", 1000, 5),
                                new Product(7, "Монитор", 20000, 5)
                        )
                )
        );

        basket = new Basket(storage);
        orders = new Orders(storage);

        System.out.println("Магазин! \nВыберите действие:");
        boolean exit = false;
        while (!exit) {
            printTextUpperMenu();
            readScanner = scanner.nextLine();
            switch (readScanner) {
                case "1":
                    storage.printAll();
                    break;
                case "2":
                    addProductToBasket();
                    break;
                case "3":
                    if (!basket.isBasketEmpty()) {
                        orders.getBasket(basket.getBasketList());
                        storage.update(basket.getBasketList());
                        basket.clearBasket();
                    }
                    break;
                case "4":
                    basket.clearBasket();
                    break;
                case "5":
                    if (!basket.isBasketEmpty()) {
                        basket.printAll();
                    }
                    break;
                case "6":
                    orders.printAll();
                    break;
                case "7":
                    exit = true;
                    break;
            }
        }
    }

    private static void addProductToBasket() {
        int productId = 0;
        productId = getNumberFromConsole(productId);
        int amountProduct = getNumberFromConsole(productId);
        basket.addProductToBasket(productId, amountProduct);
    }

    private static int getNumberFromConsole(int id) {
        if (id == 0) {
            System.out.println("Выберите товар по ID:");
        } else {
            System.out.println("Введите количество товара:");
        }
        int digitToReturn = 0;
        boolean exit = false;
        while (!exit) {
            readScanner = scanner.nextLine();
            if (readScanner.matches("[-+]?\\d+")) {
                digitToReturn = Integer.parseInt(readScanner);
                if (id == 0) {
                    int firstId = storage.getFirstId();
                    int lastId = storage.getLastId();
                    if (digitToReturn >= firstId && digitToReturn <= lastId) {
                        exit = true;
                    } else {
                        System.out.println("Нет товара с таким Id!");
                    }
                } else {
                    if (digitToReturn > 0 && digitToReturn <= storage.getRemainsById(id)) {
                        exit = true;
                    } else {
                        System.out.println("Не может быть такого количества товара!");
                    }
                }
            } else {
                System.out.println("Некорректный ввод числа!");
            }
        }
        return digitToReturn;
    }

    private static void printTextUpperMenu() {
        System.out.println("\n1. Вывести список товаров на складе");
        System.out.println("2. Добавить товар в корзину покупателя");
        System.out.println("3. Оплатить товары в корзине");
        System.out.println("4. Очистить корзину");
        System.out.println("5. Вывести корзину");
        System.out.println("6. Вывести сделанные покупки");
        System.out.println("7. Выход!");
    }
}

# Домашняя работа Magic, Dry, Solid

## Magic
Здесь мы явно задаем товары и их Id
https://github.com/MedvedvJava/SOLID-HW/blob/9e283a3fd37b78484f9b8ddbdc7746c225b1a0d4/src/Main.java#L11-L23

Но при проверке id при вводе в консоле используем методы получения самого маленького и большого id
https://github.com/MedvedvJava/SOLID-HW/blob/9e283a3fd37b78484f9b8ddbdc7746c225b1a0d4/src/Main.java#L84-L88
<br>
## Dry
В этом методе нам надо получить два числа из консоли: id и количество товара
https://github.com/MedvedvJava/SOLID-HW/blob/9e283a3fd37b78484f9b8ddbdc7746c225b1a0d4/src/Main.java#L65-L70

Проверка на целочисленность и вхождение в допустимые диапазоны я сделал в одном методе, вместо копирования кода на несколько методов.
https://github.com/MedvedvJava/SOLID-HW/blob/9e283a3fd37b78484f9b8ddbdc7746c225b1a0d4/src/Main.java#L72-L104
<br>
## Solid
### S - принцип единой ответственности
https://github.com/MedvedvJava/SOLID-HW/blob/9e283a3fd37b78484f9b8ddbdc7746c225b1a0d4/src/Basket.java#L4-L48
https://github.com/MedvedvJava/SOLID-HW/blob/9e283a3fd37b78484f9b8ddbdc7746c225b1a0d4/src/Orders.java#L4-L41
Поля классов Basket и Orders достаточно схожи и можно было бы наследовать Basket в Orders и сделать один класс для работы с корзиной и списком покупок, но тогда бы класс был бы перегружен методами.
<br>
### O
### L - наследуй, только тогда, когда можешь играть роль предка

https://github.com/MedvedvJava/SOLID-HW/blob/9e283a3fd37b78484f9b8ddbdc7746c225b1a0d4/src/Product.java#L1-L43
https://github.com/MedvedvJava/SOLID-HW/blob/9e283a3fd37b78484f9b8ddbdc7746c225b1a0d4/src/Storage.java#L1-L48
Класс Storage не наследуют класс Product, тк было бы неудобно пользоваться методами Product в классе Storage, так же нарушило бы принцип единой ответственности.
<br>
### I - принцип разделения интерфейса
https://github.com/MedvedvJava/SOLID-HW/blob/9e283a3fd37b78484f9b8ddbdc7746c225b1a0d4/src/Printable.java#L1-L3
Почти все классы используют метод печати результатов на экран, поэтому был сделан отдельный интерфейс для этого
<br>
### D - принцип инверсии зависимостей
https://github.com/MedvedvJava/SOLID-HW/blob/9e283a3fd37b78484f9b8ddbdc7746c225b1a0d4/src/Storage.java#L11-L15
Класс Storage использует для печати метод интерфейса PrintAll, но организацию вывода полей мы отдаем на класс Product
https://github.com/MedvedvJava/SOLID-HW/blob/9e283a3fd37b78484f9b8ddbdc7746c225b1a0d4/src/Product.java#L34-L42

package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    @Test
    public void removeExistProductTest() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Посудомоечная машина", 25_000);
        Product product2 = new Product(2, "Очки", 1_000);
        Product product3 = new Product(3, "Ноутбук", 60_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.removeById(1);
        Product[] actual = repo.findAll();
        Product[] expected = {product2, product3};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void removeNotExistProductTest() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Посудомоечная машина", 25_000);
        Product product2 = new Product(2, "Очки", 1_000);
        Product product3 = new Product(3, "Ноутбук", 60_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.removeById(123123)
        );

    }


}

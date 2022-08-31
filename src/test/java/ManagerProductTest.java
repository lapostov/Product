import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ManagerProductTest {


    private ManagerProductTest repository;




    @Test
    public void add() {
        Product phone1 = new Product(11, "PhoneName1", 5500);
        Product phone2 = new Product(222, "PhoneName2", 8000);
        Product phone3 = new Product(15, "PhoneName3", 6990);
        ProductRepository repo = new ProductRepository();
        ManagerProduct manager = new ManagerProduct(repo);

     manager.add(phone1);
     manager.add(phone3);

     Product[] expected = {phone1, phone3};
     Product[] actual = manager.getItems();

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void removeById() {
        ProductRepository repo = new ProductRepository();
        ManagerProduct manager = new ManagerProduct(repo);

        Product phone1 = new Product(11, "PhoneName1", 5500);
        Product phone2 = new Product(222, "PhoneName2", 8000);
        Product phone3 = new Product(15, "PhoneName3", 6990);


        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);

        manager.removeById(phone2);
        Product[] expected = {phone1, phone3};
        Product[] actual = manager.getItems();

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void findAll() {
        Product phone1 = new Product(11, "PhoneName1", 5500);
        Product phone2 = new Product(222, "PhoneName2", 8000);
        Product phone3 = new Product(15, "PhoneName3", 6990);

        ProductRepository repo = new ProductRepository();
        ManagerProduct manager = new ManagerProduct(repo);

        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);

        Product[] expected = {phone3};
        Product[] actual = manager.searchBy("Name3");

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void removeByPrice() {
        ProductRepository repo = new ProductRepository();
        ManagerProduct manager = new ManagerProduct(repo);

        Product phone1 = new Product(11, "PhoneName1", 5500);
        Product phone2 = new Product(222, "PhoneName2", 8000);
        Product phone3 = new Product(15, "PhoneName3", 6990);


        repo.add(phone1);
        repo.add(phone2);
        repo.add(phone3);


        Product[] expected = {phone2, phone3};
        Product[] actual = repo.removeByPrice(5500);

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void removeByName() {
        ProductRepository repo = new ProductRepository();
        ManagerProduct manager = new ManagerProduct(repo);

        Product phone1 = new Product(11, "PhoneName1", 5500);
        Product phone2 = new Product(222, "PhoneName2", 8000);
        Product phone3 = new Product(15, "PhoneName3", 6990);


        repo.add(phone1);
        repo.add(phone2);
        repo.add(phone3);


        Product[] expected = {phone1, phone3};
        Product[] actual = repo.removeByName("PhoneName2");

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void addRepositoryManager() {

        ProductRepository repo = new ProductRepository();
        ManagerProduct manager = new ManagerProduct(repo);

        Product phone1 = new Product(11, "PhoneName1", 5500);
        Product phone2 = new Product(222, "PhoneName2", 8000);
        Product phone3 = new Product(15, "PhoneName3", 6990);

        manager.add(phone3);
        manager.add(phone2);

        Product[] expected = {phone3, phone2};
        Product[] actual = manager.getItems();

        Assertions.assertArrayEquals(actual, expected);
    }




}


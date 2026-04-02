package az.edu.ada.wm2.lab6;

import az.edu.ada.wm2.lab6.model.Category;
import az.edu.ada.wm2.lab6.model.Product;
import az.edu.ada.wm2.lab6.repository.CategoryRepository;
import az.edu.ada.wm2.lab6.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Component
public class Runner implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public Runner(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) {
        Category category1 = new Category();
        category1.setName("Electronics");

        Category category2 = new Category();
        category2.setName("Home");

        categoryRepository.save(category1);
        categoryRepository.save(category2);

        Product product1 = new Product();
        product1.setProductName("Laptop");
        product1.setPrice(new BigDecimal("2500.00"));
        product1.setExpirationDate(LocalDate.of(2027, 1, 1));
        product1.setCategories(List.of(category1));

        Product product2 = new Product();
        product2.setProductName("Vacuum Cleaner");
        product2.setPrice(new BigDecimal("300.00"));
        product2.setExpirationDate(LocalDate.of(2028, 6, 1));
        product2.setCategories(List.of(category2));

        productRepository.save(product1);
        productRepository.save(product2);
    }
}
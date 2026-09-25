package pt.ulusofona.cd.product.repository;

import org.springframework.stereotype.Repository;
import pt.ulusofona.cd.product.model.Product;

import java.util.Optional;

@Repository
public class ProductRepository extends InMemoryRepository<Product> {

    public Optional<Product> findBySkuIgnoreCase(String sku) {
        return stream()
                .filter(product -> product.getSku().equalsIgnoreCase(sku))
                .findFirst();
    }

    public boolean existsBySkuIgnoreCase(String sku) {
        return findBySkuIgnoreCase(sku).isPresent();
    }
}
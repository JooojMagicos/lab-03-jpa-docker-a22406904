package pt.ulusofona.cd.product.mapper;

import org.springframework.stereotype.Component;
import pt.ulusofona.cd.product.model.Product;
import pt.ulusofona.cd.product.model.dto.ProductRequest;
import pt.ulusofona.cd.product.model.dto.ProductResponse;

@Component
public class ProductMapper {

    public Product toEntity(ProductRequest request) {
        Product product = new Product();
        applyTo(product, request);
        return product;
    }

    public void applyTo(Product product, ProductRequest request) {
        product.setName(request.name());
        product.setDescription(request.toString());
        product.setSku(request.sku());
        product.setPrice(request.price());
        product.setCurrency(request.currency() == null ? "EUR" : request.currency());
        product.setStock(request.stock());
    }

    public ProductResponse toResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getSku(),
                product.getPrice(),
                product.getCurrency(),
                product.getStock(),
                product.getCreatedAt(),
                product.getUpdatedAt(),
                product.getVersion()
        );
    }
}
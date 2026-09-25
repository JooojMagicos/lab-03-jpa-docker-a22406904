package pt.ulusofona.cd.product.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pt.ulusofona.cd.product.exception.DuplicateSkuException;
import pt.ulusofona.cd.product.exception.ProductNotFoundException;
import pt.ulusofona.cd.product.mapper.ProductMapper;
import pt.ulusofona.cd.product.model.Product;
import pt.ulusofona.cd.product.model.dto.ProductRequest;
import pt.ulusofona.cd.product.model.dto.ProductResponse;
import pt.ulusofona.cd.product.repository.ProductRepository;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    public ProductResponse createProduct(ProductRequest request) {
        if (repository.existsBySkuIgnoreCase(request.sku())) {
            throw new DuplicateSkuException(request.sku());
        }

        Product product = mapper.toEntity(request);
        Instant now = Instant.now();
        product.setCreatedAt(now);
        product.setUpdatedAt(now);
        product.setVersion(0);

        return mapper.toResponse(repository.save(product));
    }

    public List<ProductResponse> getAllProducts() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    public ProductResponse getProductById(UUID id) {
        return mapper.toResponse(findOrThrow(id));
    }

    public ProductResponse updateProduct(UUID id, ProductRequest request) {
        Product product = findOrThrow(id);

        repository.findBySkuIgnoreCase(request.sku())
                .filter(existing -> !existing.getId().equals(id))
                .ifPresent(existing -> {
                    throw new DuplicateSkuException(request.sku());
                });

        mapper.applyTo(product, request);
        product.setUpdatedAt(Instant.now());
        product.setVersion(product.getVersion() + 1);

        return mapper.toResponse(repository.save(product));
    }

    public void deleteProduct(UUID id) {
        if (!repository.deleteById(id)) {
            throw new ProductNotFoundException(id);
        }
    }

    private Product findOrThrow(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }
}
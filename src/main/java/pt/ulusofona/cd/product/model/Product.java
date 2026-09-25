package pt.ulusofona.cd.product.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class Product implements Identifiable {

    private UUID id;
    private String name;
    private String description;
    private String sku;
    private BigDecimal price;
    private String currency = "EUR";
    private int stock;
    private Instant createdAt;
    private Instant updatedAt;
    private int version;
}
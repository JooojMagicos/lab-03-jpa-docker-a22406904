package pt.ulusofona.cd.product.model.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record ProductResponse(
        UUID id,
        String name,
        String description,
        String sku,
        BigDecimal price,
        String currency,
        int stock,
        Instant createdAt,
        Instant updatedAt,
        int version
) {
}
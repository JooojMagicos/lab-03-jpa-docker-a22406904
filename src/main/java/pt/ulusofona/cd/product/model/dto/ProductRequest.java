package pt.ulusofona.cd.product.model.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

public record ProductRequest(

        @Schema(description = "Display name", example = "Mechanical Keyboard")
        @NotBlank(message = "name is required")
        @Size(min = 3, max = 120, message = "name must be between 3 and 120 characters")
        String name,

        @Schema(description = "Stock keeping unit, unique across all products",
                example = "KB-87-BRN")
        @NotBlank(message = "sku is required")
        @Pattern(regexp = "^[A-Z0-9-]{3,40}$",
                message = "sku must be uppercase letters, digits and hyphens, 3 to 40 characters")
        String sku,

        @NotNull(message = "price is required")
        @DecimalMin(value = "0.00", inclusive = true, message = "price must not be negative")
        @Digits(integer = 12, fraction = 2, message = "price must have at most 2 decimal places")
        BigDecimal price,

        @Pattern(regexp = "^EUR$", message = "currency must be EUR")
        String currency,

        @NotNull(message = "stock is required")
        @PositiveOrZero(message = "stock must not be negative")
        Integer stock
) {
}
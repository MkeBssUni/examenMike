package com.example.firstapp.controllers.product;

import com.example.firstapp.models.product.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDto {
    private Long id;
    @NotEmpty(message = "Required field")
    private String name;
    @NotEmpty(message = "Required field")
    private String category;
    @NotEmpty(message = "Required field")
    private double price;
    @NotEmpty(message = "Required field")
    private Boolean status=true;

    public Product castToProduct() {
        return new Product(
                getId(),
                getName(),
                getCategory(),
                getPrice(),
                getStatus(),null
        );
    }
}

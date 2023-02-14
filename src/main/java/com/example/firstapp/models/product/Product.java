package com.example.firstapp.models.product;

import com.example.firstapp.models.transaccion.Transaccion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="products")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String name;
    @Column(nullable = false, length = 150)
    private String category;
    @Column(nullable = false, length = 150)
    private double price;
    @Column(nullable = false, length = 150)
    private Boolean status;

    @ManyToOne
    @JoinColumn(name="transaccion_id", nullable=false, referencedColumnName = "id")
    private Transaccion transaccion;
}

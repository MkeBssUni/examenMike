package com.example.firstapp.models.transaccion;

import com.example.firstapp.models.product.Product;
import com.example.firstapp.models.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="products")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Id del usuario
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "transaccion", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Product> products;

    @Column(nullable = false, length = 150)
    private String date;



}

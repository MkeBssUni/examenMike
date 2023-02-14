package com.example.firstapp.models.user;

import com.example.firstapp.models.transaccion.Transaccion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String name;
    @Column(nullable = false, length = 150)
    private String email;
    @Column(nullable = false, length = 150)
    private String password;
    @Column(nullable = false, length = 150)
    private String wishlist;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, optional = false)
    private Transaccion transaccion;
}

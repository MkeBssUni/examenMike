package com.example.firstapp.services.product;

import com.example.firstapp.models.product.Product;
import com.example.firstapp.models.product.ProductRepository;
import com.example.firstapp.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional

public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public CustomResponse<List<Product>> getAll() {
        return new CustomResponse<>(
                this.repository.findAll(),
                false, 200, "Ok"
        );
    }

    @Transactional(readOnly = true)
    public CustomResponse<Product> getOne(Long id) {
        boolean exists = this.repository.existsById(id);
        if (exists) {
            return new CustomResponse<>(
                    this.repository.findById(id).get(),
                    false, 200, "Ok"
            );
        } else {
            return new CustomResponse<>(
                    null, true, 400, "No existe"
            );
        }
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Product> insert (Product producto){
        return new CustomResponse<>(
                this.repository.saveAndFlush(producto),
                false, 200, "Registro  correcto"
        );

    }

    //update
    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Product> update (Product producto){
        return new CustomResponse<>(
                this.repository.saveAndFlush(producto),
                false, 200, "Registro  correcto"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Product> delete(long id) {
        boolean exists = this.repository.existsById(id);
        if (exists) {
            this.repository.deleteById(id);
            return new CustomResponse<>(
                    null, false, 200, "OK"
            );
        } else {
            return new CustomResponse<>(
                    null, true, 400, "No existe"
            );
        }
    }

}

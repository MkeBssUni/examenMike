package com.example.firstapp.services.user;

import com.example.firstapp.models.product.Product;
import com.example.firstapp.models.user.User;
import com.example.firstapp.models.user.UserRepository;
import com.example.firstapp.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository repository;

    @Transactional(readOnly = true)
    public CustomResponse<List<User>> getAll() {
        return new CustomResponse<>(
                this.repository.findAll(),
                false, 200, "Ok"
        );
    }

    @Transactional(readOnly = true)
    public CustomResponse<User> getOne(Long id) {
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
    public CustomResponse<User> insert (User user){
        return new CustomResponse<>(
                this.repository.saveAndFlush(user),
                false, 200, "Registro  correcto"
        );

    }

    //update
    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<User> update (User user){
        return new CustomResponse<>(
                this.repository.saveAndFlush(user),
                false, 200, "Registro  correcto"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<User> delete(long id) {
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

package com.example.firstapp.services.transaccion;
import com.example.firstapp.models.transaccion.Transaccion;
import com.example.firstapp.models.transaccion.TransaccionRepository;
import com.example.firstapp.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class TransaccionService {

    @Autowired
    private TransaccionRepository repository;

    @Transactional(readOnly = true)
    public CustomResponse<List<Transaccion>> getAll() {
        return new CustomResponse<>(
                this.repository.findAll(),
                false, 200, "Ok"
        );
    }

    @Transactional(readOnly = true)
    public CustomResponse<Transaccion> getOne(Long id) {
        boolean exists = this.repository.existsById(id);
        if (exists) {
            return new CustomResponse<>(
                    this.repository.findById(id).get(),
                    false, 200, "Ok"
            );
        } else {
            return new CustomResponse<>(
                    null, true, 400, "No existe la transaccion"
            );
        }
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Transaccion> insert (Transaccion transaccion){
        return new CustomResponse<>(
                this.repository.saveAndFlush(transaccion),
                false, 200, "Transaccion registrda correctamente"
        );

    }


}

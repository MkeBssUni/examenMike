package com.example.firstapp.models.transaccion;

import com.example.firstapp.models.transaccion.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaccionRepository extends  JpaRepository<Transaccion, Long>{


}

package com.example.firstapp.controllers.transaccion;

import com.example.firstapp.controllers.product.ProductDto;
import com.example.firstapp.models.product.Product;
import com.example.firstapp.models.transaccion.Transaccion;
import com.example.firstapp.services.transaccion.TransaccionService;
import com.example.firstapp.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/examen/transaccion")
@CrossOrigin(origins = {"*"})
public class TransaccionController {

    @Autowired
    private TransaccionService service;

    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<Transaccion>>> getAll(){
        return new ResponseEntity<>(
                this.service.getAll(),
                HttpStatus.OK
        );
    }
    @PostMapping("/")
    public ResponseEntity<CustomResponse<Transaccion>> insert(
            @Valid @RequestBody Transaccion transaccion
    ){
        return new ResponseEntity<>(
                this.service.insert(transaccion),
                HttpStatus.OK
        );
    }
}

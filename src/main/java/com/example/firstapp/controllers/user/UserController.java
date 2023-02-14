package com.example.firstapp.controllers.user;

import com.example.firstapp.models.user.User;
import com.example.firstapp.services.user.UserService;
import com.example.firstapp.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/examen/user")
@CrossOrigin(origins = {"*"})
public class UserController {

        @Autowired
        private UserService service;

        @GetMapping("/")
        public ResponseEntity<CustomResponse<List<User>>> getAll(){
            return new ResponseEntity<>(
                    this.service.getAll(),
                    HttpStatus.OK
            );
        }

        @PostMapping("/")
        public ResponseEntity<CustomResponse<User>> insert(
                @Valid @RequestBody UserDto userDto
        ){
            return new ResponseEntity<>(
                    this.service.insert(userDto.castToUser()),
                    HttpStatus.OK
            );
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<CustomResponse<User>> delete(@PathVariable long id){
            return new ResponseEntity<>(
                    this.service.delete(id),
                    HttpStatus.OK
            );
        }

        @PutMapping("/")
        public ResponseEntity<CustomResponse<User>> update(@Valid @RequestBody UserDto user
        ){
            return new ResponseEntity<>(
                    this.service.update(user.castToUser()),
                    HttpStatus.OK
            );
        }
}

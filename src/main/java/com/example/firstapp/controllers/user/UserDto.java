package com.example.firstapp.controllers.user;

import com.example.firstapp.models.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private Long id;
    @NotEmpty(message = "Required field")
    private String name;
    @NotEmpty(message = "Required field")
    private String email;
    @NotEmpty(message = "Required field")
    private String password;
    @NotEmpty(message = "Required field")
    private String wishlist;

    public User castToUser() {
        return new User(
                getId(),
                getName(),
                getEmail(),
                getPassword(),
                getWishlist(),null
        );
    }

}

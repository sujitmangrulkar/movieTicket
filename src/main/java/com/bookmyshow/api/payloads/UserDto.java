package com.bookmyshow.api.payloads;

import com.bookmyshow.api.helper.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class UserDto implements UserDetails
{
    private String userId;

    @NotEmpty
    @Size(min=4,message="Username must be of minimum 4 characters")
    private String userName;

    @Email(message = "Email Address is not valid")
    private String email;

    @NotEmpty
    @Size(min = 3,max = 10,message="Password must be min of 3 characters to 10 chars!!")
    private String password;

    private Role role;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

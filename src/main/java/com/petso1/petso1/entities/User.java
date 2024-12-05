package com.petso1.petso1.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String username; // Email
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String role; // e.g., ROLE_USER, ROLE_ADMIN
    @Column(nullable = false)
    private boolean locked; // false means account is unlocked
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String county; // e.g., 'Cork', 'Kerry'

    // Explicitly implement getUsername()
    @Override
    public String getUsername() {
        return username;
    }

    // Explicitly implement getPassword()
    @Override
    public String getPassword() {
        return password;
    }

    // Implementing UserDetails methods
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
// Return the roles as GrantedAuthority collection
        return Collections.singletonList(new SimpleGrantedAuthority(role));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Account is valid
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked; // Account is non-locked if 'locked' is false
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Credentials are valid
    }

    @Override
    public boolean isEnabled() {
        return true; // Account is enabled
    }
}
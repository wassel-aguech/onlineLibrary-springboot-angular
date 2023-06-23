package com.example.pfltestback.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;


@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String lastname;
    private String email;
    private String password;
    private Integer DownloadsRemaining;
    @Enumerated(EnumType.STRING)
    private Role role;



    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Book> books;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<DownloadStatistics> downloadStatistics;



    public Integer getDownloadsRemaining() {
        if (DownloadsRemaining == null) {
            return 5;
        }
        return DownloadsRemaining;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (role == null) {
            return Collections.emptyList(); // or return null, or handle it in a different way based on your requirements
        }
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return email;
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

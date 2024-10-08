package io.muzoo.ssc.springwebapp.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Builder
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Account Details
    @Column(unique = true)
    private String username;

    @Column(nullable = false)
    private String email;

    private String address;

    @Column(nullable = false)
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String phoneNumber;

    private int age;

    @Column(name = "height_in_cm")
    private double height;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "contact_number")
    private String contact;

    @Column(length = 5000)
    private String biography;

    @Enumerated(EnumType.STRING)
    Role role;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;


    @ElementCollection
    @Column(name = "preference")
    private Set<String> preferences = new HashSet<>();

    @ElementCollection
    @Column(name = "dislike")
    private Set<String> dislikes = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        // our "username" for security is the email field
        return username;
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

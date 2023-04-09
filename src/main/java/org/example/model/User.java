package org.example.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "app_user")
public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "userId", updatable = false, nullable = false)
    private UUID user_id;
    private String name;
    private String email;
    private String password;
    @ElementCollection
    @CollectionTable(name = "roles")
    @JoinColumn(name = "user_id")
    @Fetch(value = FetchMode.JOIN)
    @Column(name = "roles")
    private Set<String> roles = new HashSet<>();

    public User() {
    }

    public User(UUID user_id, String name, String email, String password, Set<String> roles) {
        this.user_id = user_id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public User(String name, String email, String password, Set<String> roles) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public UUID getUser_id() {
        return user_id;
    }

    public void setUser_id(UUID user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}

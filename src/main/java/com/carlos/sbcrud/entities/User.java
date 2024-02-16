package com.carlos.sbcrud.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_users")
    private Long id_users;

    @Column(name = "username", unique = true)
    @NotBlank
    @Size(min=4,max = 12)
    private String username;

    @Column(name = "contraseña")
    @NotBlank
    private String clave;

    @Column(name = "enabled")
    private Boolean enabled;


    @ManyToMany
    @JoinTable(
        name="users_roles",
        joinColumns = @JoinColumn(name="id_users"),
        inverseJoinColumns = @JoinColumn(name="id_roles"),
        uniqueConstraints = {@UniqueConstraint(columnNames = {"id_users","id_roles"})}
    )
    private List<Role> roles;

    @Transient
    private boolean admin;


    public User(String username, String clave, Boolean enabled) {
        this.username = username;
        this.clave = clave;
        this.enabled = enabled;
    }

    public Long getId_users() {
        return id_users;
    }

    public void setId_users(Long id_users) {
        this.id_users = id_users;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    

    
    
}

package com.carlos.sbcrud.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_roles")
    private Long id_roles;

    @Column(name = "nombre", unique = true)
    private String name;

    //Constructores

    public Role(String nombre) {
        this.name = nombre;
    }

    public Role() {
    }



    public Long getId_roles() {
        return id_roles;
    }

    public void setId_roles(Long id_roles) {
        this.id_roles = id_roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String nombre) {
        this.name = nombre;
    }

    @Override
    public String toString() {
        return "Role [id_roles=" + id_roles + ", nombre=" + name + "]";
    }

    
    
    

}

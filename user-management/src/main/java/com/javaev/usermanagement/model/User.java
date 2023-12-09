package com.javaev.usermanagement.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID; // Importar la clase UUID

import org.hibernate.annotations.GenericGenerator;

@Entity
public class User {
    @Id
    @GeneratedValue(generator = "uuid2") // Utilizar el generador 'uuid2' que es estándar en Hibernate
    @GenericGenerator(name = "uuid2", strategy = "uuid2") // Definir el generador para usar la estrategia UUID
    private UUID id; // Cambiar el tipo de 'Long' a 'UUID'

    private String name;
    private String email;
    private String password;
    private Date created;
    private Date modified;
    private Date lastLogin;
    private String token;
    private Boolean isActive;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Phone> phones = new HashSet<>();


    // Getter and setters are methods that acces and modify private variables values.
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { // Parameter
        this.name = name; // 'this.name' refers to the variable instance, 'name' is the parameter
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

    public Date getCreated() {
        return created;
    }

    public void setDate(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Date getLastLogin() {
        return lastLogin;
    }
    
    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}

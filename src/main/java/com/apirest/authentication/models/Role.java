package com.apirest.authentication.models;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {
    
    @Id
    @GeneratedValue
    private UUID id;
    private String name;

    public Role() {
    }
    
    public Role(UUID id, String name) {
      this.id = id;
      this.name = name;
    }

    public Role(UUID id) {
      this.id = id;
    }

    public UUID getId() {
      return id;
    }

    public String getName() {
      return name;
    }
}

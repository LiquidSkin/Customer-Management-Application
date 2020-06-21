package com.example.customermanagement.CustomerManagement.Models;


import com.sun.istack.NotNull;


import javax.persistence.*;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @NotNull
    private String Name;

    @NotNull
    private String Address;

    public User()
    {

    }

    public User(Long id, String name, String address) {
        Id = id;
        Name = name;
        Address = address;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}

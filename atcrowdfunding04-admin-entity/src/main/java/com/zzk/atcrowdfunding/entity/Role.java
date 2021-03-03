package com.zzk.atcrowdfunding.entity;

public class Role {
    private Integer id;
    public Role() {
    }

    public Role(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}
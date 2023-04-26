package com.mayikt.entity;

public class MayiktUserInfoEntity {
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "MayiktUserInfoEntity{" +
                "address='" + address + '\'' +
                '}';
    }
}

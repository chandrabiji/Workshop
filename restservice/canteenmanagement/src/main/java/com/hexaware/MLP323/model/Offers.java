package com.hexaware.MLP323.model;

import java.util.Objects;

public class Offers{
    private int id;
    private String name;
    private Double share;
    private String message;
    private int vendorId;

    public Offers() {
    }

    public Offers(int id, String name, Double share, String message, int vendorId) {
        this.id = id;
        this.name = name;
        this.share = share;
        this.message = message;
        this.vendorId = vendorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offers offers = (Offers) o;
        return id == offers.id &&
                Objects.equals(name, offers.name) &&
                Objects.equals(share, offers.share) &&
                Objects.equals(message, offers.message) &&
                Objects.equals(vendorId, offers.vendorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, share, message, vendorId);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getShare() {
        return share;
    }

    public void setShare(Double share) {
        this.share = share;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }
}

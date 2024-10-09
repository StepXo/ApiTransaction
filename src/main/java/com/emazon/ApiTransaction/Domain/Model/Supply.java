package com.emazon.ApiTransaction.Domain.Model;

import com.emazon.ApiTransaction.Domain.Utils.SupplyBuilder;

public class Supply {
    private long id;
    private long idUser;
    private long idItem;
    private int quantity;
    private String date;

    public Supply(SupplyBuilder builder) {
        this.id = builder.id;
        this.idUser = builder.idUser;
        this.idItem = builder.idItem;
        this.quantity = builder.quantity;
        this.date = builder.date;
    }

    public static SupplyBuilder builder() {
        return new SupplyBuilder();
    }

    public Supply() {
    }

    public long getId() {
        return id;
    }

    public long getIdUser() {
        return idUser;
    }

    public long getIdItem() {
        return idItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDate() {
        return date;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public void setIdItem(long idItem) {
        this.idItem = idItem;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

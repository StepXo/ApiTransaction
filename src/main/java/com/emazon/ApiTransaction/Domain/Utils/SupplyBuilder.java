package com.emazon.ApiTransaction.Domain.Utils;

import com.emazon.ApiTransaction.Domain.Model.Supply;

public class SupplyBuilder {
    private long id;
    private long idUser;
    private long idItem;
    private int quantity;
    private String date;

    public SupplyBuilder setId(long id) {
        this.id = id;
        return this;
    }

    public SupplyBuilder setIdUser(long idUser) {
        this.idUser = idUser;
        return this;
    }

    public SupplyBuilder setIdItem(long idItem) {
        this.idItem = idItem;
        return this;
    }

    public SupplyBuilder setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public SupplyBuilder setDate(String date) {
        this.date = date;
        return this;
    }

    public Supply build() {
        return new Supply(this);
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
}

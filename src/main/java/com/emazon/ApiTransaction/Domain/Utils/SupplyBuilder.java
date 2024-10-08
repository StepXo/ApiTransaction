package com.emazon.ApiTransaction.Domain.Utils;

import com.emazon.ApiTransaction.Domain.Model.Supply;

public class SupplyBuilder {
    public long id;
    public long idUser;
    public long idItem;
    public long quantity;
    public String date;

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

    public SupplyBuilder setQuantity(long quantity) {
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


}

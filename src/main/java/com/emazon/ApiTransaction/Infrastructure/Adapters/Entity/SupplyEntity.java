package com.emazon.ApiTransaction.Infrastructure.Adapters.Entity;

import com.emazon.ApiTransaction.Infrastructure.Utils.InfraConstants;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = InfraConstants.TABLE_SUPPLY)
public class SupplyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private long idUser;
    private long idItem;
    private int quantity;
    private String date;
}

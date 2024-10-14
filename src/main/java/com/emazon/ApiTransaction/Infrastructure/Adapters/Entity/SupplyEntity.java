package com.emazon.ApiTransaction.Infrastructure.Adapters.Entity;

import com.emazon.ApiTransaction.Infrastructure.Utils.InfraConstants;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.emazon.ApiTransaction.Infrastructure.Utils.InfraConstants.ID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = InfraConstants.TABLE_SUPPLY)
public class SupplyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ID)
    private Long id;
    private long idUser;
    private long idItem;
    private int quantity;
    private String date;
}

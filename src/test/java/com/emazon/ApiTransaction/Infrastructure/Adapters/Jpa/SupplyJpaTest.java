package com.emazon.ApiTransaction.Infrastructure.Adapters.Jpa;

import com.emazon.ApiTransaction.Domain.Model.Supply;
import com.emazon.ApiTransaction.Domain.Spi.SupplyRepositoryPort;
import com.emazon.ApiTransaction.Infrastructure.Adapters.Entity.SupplyEntity;
import com.emazon.ApiTransaction.Infrastructure.Adapters.Mapper.SupplyMapper;
import com.emazon.ApiTransaction.Infrastructure.Adapters.Respository.SupplyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class SupplyJpaTest {

    @Mock
    private SupplyMapper mapper;

    @Mock
    private SupplyRepository repository;

    @InjectMocks
    private SupplyJpa supplyJpa;
    private Supply supply;
    private SupplyEntity supplyEntity;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        //
        supply = Supply.builder()
                .setId(1L)
                .setIdItem(100L)
                .setQuantity(50)
                .build();
        supplyEntity = new SupplyEntity();
        supplyEntity.setId(1L);
        supplyEntity.setIdItem(100L);
        supplyEntity.setQuantity(50);
    }

    @Test
    void saveSupply_ShouldReturnSavedSupply_WhenSupplyIsValid() {


        when(mapper.toSupplyEntity(supply)).thenReturn(supplyEntity);
        when(repository.save(supplyEntity)).thenReturn(supplyEntity);
        when(mapper.toSupply(supplyEntity)).thenReturn(supply);

        Supply result = supplyJpa.saveSupply(supply);

        assertNotNull(result);
        assertEquals(supply.getId(), result.getId());
        assertEquals(supply.getIdItem(), result.getIdItem());
        assertEquals(supply.getQuantity(), result.getQuantity());

        verify(mapper).toSupplyEntity(supply);
        verify(repository).save(supplyEntity);
        verify(mapper).toSupply(supplyEntity);
    }

    @Test
    void saveSupply_ShouldThrowException_WhenMapperThrowsException() {
        Supply supply = Supply.builder().setId(1L).setIdItem(100L).setQuantity(50).build();

        when(mapper.toSupplyEntity(supply)).thenThrow(new RuntimeException("Mapping error"));

        assertThrows(RuntimeException.class, () -> supplyJpa.saveSupply(supply));

        verify(repository, never()).save(any());
    }
}

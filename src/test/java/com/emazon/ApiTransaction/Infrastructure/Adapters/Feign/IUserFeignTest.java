package com.emazon.ApiTransaction.Infrastructure.Adapters.Feign;

import com.emazon.ApiTransaction.Application.Response.ItemAuxDto;
import com.emazon.ApiTransaction.Domain.Model.Supply;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class IStockFeignTest {

    @Mock
    private IStockFeign stockFeign;

    @InjectMocks
    private IStockFeignTest stockFeignTest;
    private Supply supply;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        // Arrange
        supply = Supply.builder()
                .setIdItem(100L)
                .setQuantity(50)
                .build();
    }

    @Test
    void updateStock_ShouldCallIncreaseStock_WhenSupplyIsValid() {


        ItemAuxDto expectedResponse = new ItemAuxDto(100L, 50L);
        when(stockFeign.increaseStock(any(ItemAuxDto.class))).thenReturn(expectedResponse);

        stockFeign.updateStock(supply);

        verify(stockFeign).increaseStock(any(ItemAuxDto.class));
    }

    @Test
    void increaseStock_ShouldReturnItemAuxDto_WhenRequestIsValid() {
        ItemAuxDto itemAuxDto = new ItemAuxDto(100L, 50L);

        when(stockFeign.increaseStock(itemAuxDto)).thenReturn(itemAuxDto);

        // Act
        ItemAuxDto result = stockFeign.increaseStock(itemAuxDto);

        // Assert
        assertNotNull(result);
        assertEquals(itemAuxDto.getId(), result.getId());
        assertEquals(itemAuxDto.getQuantity(), result.getQuantity());
    }
}

package com.emazon.ApiTransaction.Domain.Usecase;

import com.emazon.ApiTransaction.Domain.Exeption.InvalidQuantityException;
import com.emazon.ApiTransaction.Domain.Model.Supply;
import com.emazon.ApiTransaction.Domain.Spi.StockFeignPort;
import com.emazon.ApiTransaction.Domain.Spi.SupplyRepositoryPort;
import com.emazon.ApiTransaction.Domain.Spi.UserJwtPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SupplyUseCaseTest {

    @Mock
    private SupplyRepositoryPort supplyRepositoryPort;

    @Mock
    private StockFeignPort stockFeignPort;

    @Mock
    private UserJwtPort userJwt;

    @InjectMocks
    private SupplyUseCase supplyUseCase;

    private Supply supply;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        supply = new Supply();
        supply.setIdItem(1L);
        supply.setQuantity(10);
    }

    @Test
    void saveSupply_ShouldSaveSupplySuccessfully() {
        // Arrange
        String userId = "1";
        when(userJwt.extractUserId()).thenReturn(userId);
        when(supplyRepositoryPort.saveSupply(any(Supply.class))).thenReturn(supply);

        // Act
        Supply result = supplyUseCase.saveSupply(supply);

        // Assert
        assertNotNull(result);
        assertEquals(supply, result);
        assertEquals(Long.parseLong(userId), supply.getIdUser());
        assertEquals(LocalDate.now().toString(), supply.getDate());

        // Verifica que se llamó a la actualización de stock
        verify(stockFeignPort).updateStock(supply);
        // Verifica que se guardó la entidad Supply
        verify(supplyRepositoryPort).saveSupply(supply);
    }

    @Test
    void saveSupply_ShouldThrowException_WhenValidationFails() {
        // Arrange
        String userId = "1";
        when(userJwt.extractUserId()).thenReturn(userId);

        // Forzamos un valor inválido para el Supply que haga fallar la validación
        supply.setQuantity(0); // Esta cantidad debería provocar una excepción

        // Act and Assert
        assertThrows(InvalidQuantityException.class, () -> supplyUseCase.saveSupply(supply));

        // Verifica que no se llame a la actualización de stock ni al guardado del supply
        verify(stockFeignPort, never()).updateStock(supply);
        verify(supplyRepositoryPort, never()).saveSupply(supply);
    }

    @Test
    void saveSupply_ShouldCallStockUpdate() {
        // Arrange
        String userId = "1";
        when(userJwt.extractUserId()).thenReturn(userId);
        when(supplyRepositoryPort.saveSupply(any(Supply.class))).thenReturn(supply);

        // Act
        supplyUseCase.saveSupply(supply);

        // Assert
        verify(stockFeignPort).updateStock(supply);
    }
}

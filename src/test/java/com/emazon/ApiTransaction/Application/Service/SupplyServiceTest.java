package com.emazon.ApiTransaction.Application.Service;

import com.emazon.ApiTransaction.Application.Handler.SupplyHandler;
import com.emazon.ApiTransaction.Application.Request.SupplyRequest;
import com.emazon.ApiTransaction.Application.Response.SupplyResponse;
import com.emazon.ApiTransaction.Domain.Api.SupplyServicePort;
import com.emazon.ApiTransaction.Domain.Model.Supply;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class SupplyServiceTest {

    @Mock
    private SupplyHandler handler;

    @Mock
    private SupplyServicePort supplyServicePort;

    @InjectMocks
    private SupplyService supplyService;

    private Supply savedSupply;
    private SupplyRequest request;
    private SupplyResponse response;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa los mocks
        request = new SupplyRequest();
        request.setId(1L);
        request.setItemId(100L);
        request.setQuantity(50);

        savedSupply = Supply.builder()
                .setId(1L)
                .setIdItem(100L)
                .setQuantity(50)
                .setDate(LocalDate.now().toString())
                .build();
        response = new SupplyResponse(1,1, 100, 50, LocalDate.now().toString());

    }

    @Test
    void saveSupply_ShouldReturnSupplyResponse_WhenRequestIsValid() {

        when(supplyServicePort.saveSupply(any(Supply.class))).thenReturn(savedSupply);
        when(handler.toResponse(savedSupply)).thenReturn(response);

        SupplyResponse result = supplyService.saveSupply(request);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals(100L, result.getIdItem());
        assertEquals(50L, result.getQuantity());

        verify(supplyServicePort).saveSupply(any(Supply.class));
        verify(handler).toResponse(savedSupply);
    }

    @Test
    void saveSupply_ShouldCallSupplyServicePortAndHandlerCorrectly() {

        when(supplyServicePort.saveSupply(any(Supply.class))).thenReturn(savedSupply);
        when(handler.toResponse(any(Supply.class))).thenReturn(response);

        SupplyResponse result = supplyService.saveSupply(request);

        assertNotNull(result);
        assertEquals(response, result);

        verify(supplyServicePort, times(1)).saveSupply(any(Supply.class));
        verify(handler, times(1)).toResponse(any(Supply.class));
    }
}

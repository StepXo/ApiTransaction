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

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SupplyServiceTest {

    @Mock
    private SupplyHandler handler;

    @Mock
    private SupplyServicePort supplyServicePort;

    @InjectMocks
    private SupplyService supplyService;
    private String expectedDate;
    private Supply supply;
    private SupplyRequest request;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        request = new SupplyRequest(1L, 10, 100);
        supply = Supply.builder()
                .setId(request.getId())
                .setIdItem(request.getItemId())
                .setQuantity(request.getQuantity())
                .build();
        expectedDate = "2024-10-13";

    }

    @Test
    void saveSupply_ShouldReturnSupplyResponse_WhenSupplyIsSaved() {

        SupplyResponse expectedResponse = new SupplyResponse();
        expectedResponse.setId(supply.getId());
        expectedResponse.setQuantity(supply.getQuantity());
        expectedResponse.setDate(expectedDate);

        when(supplyServicePort.saveSupply(supply)).thenReturn(supply);
        when(handler.toResponse(supply)).thenReturn(expectedResponse);

        SupplyResponse result = supplyService.saveSupply(request);

        assertNotNull(result, "El resultado no debería ser null");
        assertEquals(expectedResponse, result, "La respuesta devuelta no coincide con la esperada");

        verify(supplyServicePort).saveSupply(supply);
        verify(handler).toResponse(supply);
    }

    @Test
    void checkDate_ShouldReturnDate_WhenCalledWithId() {
        long id = 1L;

        when(supplyServicePort.checkDate(id)).thenReturn(expectedDate);

        String result = supplyService.checkDate(id);

        assertNotNull(result);
        assertEquals(expectedDate, result);

        verify(supplyServicePort).checkDate(id);
    }

    @Test
    void checkDate_ShouldReturnDate_WhenCalledWithListOfIds() {
        List<Long> ids = List.of(1L, 2L, 3L);
        when(supplyServicePort.checkDate(ids)).thenReturn(expectedDate);

        String result = supplyService.checkDate(ids);

        assertNotNull(result);
        assertEquals(expectedDate, result);

        verify(supplyServicePort).checkDate(ids);
    }
}

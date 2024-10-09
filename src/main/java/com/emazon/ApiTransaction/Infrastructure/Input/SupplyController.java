package com.emazon.ApiTransaction.Infrastructure.Input;

import com.emazon.ApiTransaction.Application.Request.SupplyRequest;
import com.emazon.ApiTransaction.Application.Response.SupplyResponse;
import com.emazon.ApiTransaction.Application.Service.SupplyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
public class SupplyController {
    private final SupplyService service;

    @PostMapping("/supply")
    public ResponseEntity<SupplyResponse> newSupply(
            @Valid @RequestBody SupplyRequest request
    ) {
        return ResponseEntity.ok(service.saveSupply(request));
    }

}

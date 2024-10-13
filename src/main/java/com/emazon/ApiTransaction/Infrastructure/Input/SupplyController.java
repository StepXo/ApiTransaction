package com.emazon.ApiTransaction.Infrastructure.Input;

import com.emazon.ApiTransaction.Application.Request.SupplyRequest;
import com.emazon.ApiTransaction.Application.Response.SupplyResponse;
import com.emazon.ApiTransaction.Application.Service.SupplyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/date")
    public ResponseEntity<String> checkDate(
            @RequestParam long id
    ) {
        return ResponseEntity.ok(service.checkDate(id));
    }
    @GetMapping("/date/")
    public ResponseEntity<String> checkDates(
            @RequestParam List<Long> id
    ) {
        return ResponseEntity.ok(service.checkDate(id));
    }


}

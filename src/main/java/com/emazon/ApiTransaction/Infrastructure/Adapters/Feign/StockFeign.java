package com.emazon.ApiTransaction.Infrastructure.Adapters.Feign;

import com.emazon.ApiTransaction.Application.Response.ItemAuxDto;
import com.emazon.ApiTransaction.Domain.Model.Supply;
import com.emazon.ApiTransaction.Domain.Spi.StockFeignPort;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "Api-Stock", url = "http://localhost:9091/item") // Ajusta la URL según tu configuración
public interface StockFeign extends StockFeignPort {

    @Override
    default void updateStock(Supply supply) {
        increaseStock(supply.getIdItem(),(int) supply.getQuantity());
    }

    @PostMapping("/increase")
    ItemAuxDto increaseStock(
            @RequestParam("articleId") long articleId,
            @RequestParam("quantity") int quantity);
}

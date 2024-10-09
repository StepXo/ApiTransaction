package com.emazon.ApiTransaction.Infrastructure.Adapters.Feign;

import com.emazon.ApiTransaction.Application.Response.ItemAuxDto;
import com.emazon.ApiTransaction.Domain.Model.Supply;
import com.emazon.ApiTransaction.Domain.Spi.StockFeignPort;
import com.emazon.ApiTransaction.Infrastructure.Configuration.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "Api-Stock", url = "http://localhost:9091/item",configuration = FeignConfiguration.class)
public interface IStockFeign extends StockFeignPort {

    @Override
    default void updateStock(Supply supply) {
        ItemAuxDto item = new ItemAuxDto(supply.getIdItem(), supply.getQuantity());
        increaseStock(item);
    }

    @PostMapping( value = "/increase", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    ItemAuxDto increaseStock(@RequestBody ItemAuxDto increaseStockDto);
}

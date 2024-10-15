package com.emazon.ApiTransaction.Infrastructure.Adapters.Feign;

import com.emazon.ApiTransaction.Application.Response.ItemAuxDto;
import com.emazon.ApiTransaction.Domain.Model.Supply;
import com.emazon.ApiTransaction.Domain.Spi.StockFeignPort;
import com.emazon.ApiTransaction.Infrastructure.Configuration.FeignConfiguration;
import com.emazon.ApiTransaction.Infrastructure.Utils.InfraConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = InfraConstants.API_STOCK, url = "${stock.api.url}",configuration = FeignConfiguration.class)
public interface IStockFeign extends StockFeignPort {

    @Override
    default void updateStock(Supply supply) {
        ItemAuxDto item = new ItemAuxDto(supply.getIdItem(), supply.getQuantity());
        increaseStock(item);
    }

    @PostMapping( value = InfraConstants.INCREASE, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    ItemAuxDto increaseStock(@RequestBody ItemAuxDto increaseStockDto);
}

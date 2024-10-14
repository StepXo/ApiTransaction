package com.emazon.ApiTransaction.Infrastructure.Adapters.Feign;

import com.emazon.ApiTransaction.Application.Response.UserResponse;
import com.emazon.ApiTransaction.Infrastructure.Configuration.FeignConfiguration;
import com.emazon.ApiTransaction.Infrastructure.Utils.InfraConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = InfraConstants.API_USER, url = "http://localhost:9090/admin",configuration = FeignConfiguration.class)
public interface IUserFeign {

    @GetMapping(value = InfraConstants.GET_USER,consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    UserResponse getUserById(@PathVariable String id);

}

package com.emazon.ApiTransaction.Infrastructure.Configuration;

import com.emazon.ApiTransaction.Application.Handler.SupplyHandler;
import com.emazon.ApiTransaction.Application.Service.SupplyService;
import com.emazon.ApiTransaction.Domain.Api.SupplyServicePort;
import com.emazon.ApiTransaction.Domain.Spi.StockFeignPort;
import com.emazon.ApiTransaction.Domain.Spi.SupplyRepositoryPort;
import com.emazon.ApiTransaction.Domain.Spi.UserJwtPort;
import com.emazon.ApiTransaction.Domain.Usecase.SupplyUseCase;
import com.emazon.ApiTransaction.Infrastructure.Adapters.Feign.StockFeign;
import com.emazon.ApiTransaction.Infrastructure.Adapters.Feign.IUserFeign;
import com.emazon.ApiTransaction.Infrastructure.Adapters.Utils.UserExtractor;
import com.emazon.ApiTransaction.Infrastructure.Adapters.Jpa.SupplyJpa;
import com.emazon.ApiTransaction.Infrastructure.Adapters.Mapper.SupplyMapper;
import com.emazon.ApiTransaction.Infrastructure.Adapters.Respository.SupplyRepository;
import com.emazon.ApiTransaction.Infrastructure.Adapters.SecurityConfig.JwtSecurity.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanCondiguration {
    private final SupplyMapper mapper;
    private final SupplyRepository supplyRepository;
    private final SupplyHandler supplyHandler;
    private final JwtService jwtService;
    private final StockFeign stockFeign;


    @Bean
    public SupplyRepositoryPort supplyRepositoryPort(){
        return new SupplyJpa(mapper,supplyRepository);
    }

    @Bean
    public UserJwtPort userJwtPort() {
        return new UserExtractor(jwtService);
    }
    @Bean
    public StockFeignPort stockFeignPort(){
        return stockFeign;
    }


    @Bean
    public SupplyServicePort supplyServicePort(){
        return new SupplyUseCase(supplyRepositoryPort(),stockFeignPort(),userJwtPort());
    }

    @Bean
    public SupplyService supplyService() {
        return new SupplyService(supplyHandler,supplyServicePort());
    }




}

package com.ashokit.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Set;

@Component
public class MyFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("filter()- executed....");

        // TODO: validate request

        ServerHttpRequest request=exchange.getRequest();
        HttpHeaders httpHeaders=request.getHeaders();

        Set<String> keySet=httpHeaders.keySet();

        if(!keySet.contains("Secret")){
            throw new RuntimeException("Invalid Request");
        }

        List<String> list = httpHeaders.get("Secret");
        if(!list.get(0).equals("ashokit@123")){
            throw new RuntimeException("Invalid Request");
        }

        return chain.filter(exchange);
    }
}

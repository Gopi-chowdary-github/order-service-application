package com.microservice.orderservice.configuration;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class RequestInterceptor extends OncePerRequestFilter {

    JwtService jwtService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {


       final String auth =request.getHeader("Authentication");
      if(auth==null ||! auth.startsWith("Bearer ")){
          filterChain.doFilter(request,response);
          return;
        };
    }
}

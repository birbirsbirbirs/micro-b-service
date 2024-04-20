package co.pitam.bservice.config;

import io.micrometer.tracing.Tracer;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@RequiredArgsConstructor
@Slf4j
@Configuration
public class RestInterceptor extends OncePerRequestFilter {
    private final Tracer tracer;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if(!tracer.getAllBaggage().containsKey("power")){
            tracer.createBaggageInScope("power", null);
        }
        if(!tracer.getAllBaggage().containsKey("customerId")){
            tracer.createBaggageInScope("customerId", null);
        }
        filterChain.doFilter(request, response);
    }
}

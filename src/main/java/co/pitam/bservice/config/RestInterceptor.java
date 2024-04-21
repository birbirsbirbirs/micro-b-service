package co.pitam.bservice.config;

import io.micrometer.tracing.Tracer;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.autoconfigure.tracing.TracingProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Slf4j
@Configuration
public class RestInterceptor extends OncePerRequestFilter {
    private final Tracer tracer;
    private final TracingProperties tracingProperties;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        Map<String, String> allBaggage = tracer.getAllBaggage();
        List<String> fields = tracingProperties.getBaggage().getCorrelation().getFields();
//        fields.parallelStream().filter(p->!allBaggage.containsKey(p)).forEach(p->tracer.createBaggageInScope(p,null));
//
        filterChain.doFilter(request, response);
    }
}

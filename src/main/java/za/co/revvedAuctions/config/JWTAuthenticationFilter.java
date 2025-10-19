package za.co.revvedAuctions.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import za.co.revvedAuctions.domain.User;
import za.co.revvedAuctions.service.implementation.AuthService;
import za.co.revvedAuctions.service.implementation.JWTService;

@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter {

    private final JWTService jwtService;
    private final AuthService authService;
    private final HandlerExceptionResolver handlerExceptionResolver;

    public JWTAuthenticationFilter(JWTService jwtService, AuthService authService, HandlerExceptionResolver handlerExceptionResolver) {
        this.jwtService = jwtService;
        this.authService = authService;
        this.handlerExceptionResolver = handlerExceptionResolver;
    }

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            try {
                String jwt = authHeader.substring(7);
                String userEmail = jwtService.extractUsername(jwt);

                if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {

                    User user = authService.loadUserByEmail(userEmail);

                    if (user != null && jwtService.isTokenValid(jwt, user)) {

                        UsernamePasswordAuthenticationToken authToken =
                                new UsernamePasswordAuthenticationToken(user, null, List.of());
                        authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                        SecurityContextHolder.getContext().setAuthentication(authToken);
                    }
                }

                filterChain.doFilter(request, response);

            } catch (Exception e) {
                handlerExceptionResolver.resolveException(request, response, null, e);
            }
        } else {
            filterChain.doFilter(request, response);
        }
    }

}

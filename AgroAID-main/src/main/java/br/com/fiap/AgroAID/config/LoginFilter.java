package br.com.fiap.AgroAID.config;

import java.io.IOException;

import br.com.fiap.AgroAID.repository.UserRepository;
import br.com.fiap.AgroAID.model.User;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.filter.OncePerRequestFilter;

public class LoginFilter extends OncePerRequestFilter {
    UserRepository repository;

    public LoginFilter(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
        throws ServletException, IOException {
                
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            if(authentication != null){
                var user = (OAuth2User) authentication.getPrincipal();
                var userDb = repository.findById(user.getAttribute("avatar_url"));
                
                if(userDb.isEmpty()){
                    repository.save(User.convert(user));
                }
                
            }

            filterChain.doFilter(request, response);

    }
}

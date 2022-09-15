package br.letscode.ecommerce.configuration.security.jwt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import br.letscode.ecommerce.configuration.security.SecurityConstants;
import br.letscode.ecommerce.configuration.security.userConfig.UserLoginDto;
import br.letscode.ecommerce.configuration.security.userConfig.UserPrincipalDetails;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    // Cria URL que recebera a autenticacao
    // Pagina de login customizada
    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        setFilterProcessesUrl("/login");
    }

    // Quando a pagina /login for acessada, a request sera trazida para aqui, afim
    // de tentar autenticar o valor.
    // Eh esperado que email e senha sejam passados em um metodo POST para esse
    // /login
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
            HttpServletResponse response) throws AuthenticationException {
                log.debug(String.valueOf(request));
        try {
            UserLoginDto creds = new ObjectMapper()
                    .readValue(request.getInputStream(), UserLoginDto.class);

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getEmail(),
                            creds.getSenha(),
                            new ArrayList<>()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    // Caso a autenticacao seja feita com sucesso, cria-se um novo token valido,
    // baseado no email e roles desse email
    @Override
    protected void successfulAuthentication(HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain,
            Authentication authResult) throws IOException, ServletException {

        String email = ((UserPrincipalDetails) authResult.getPrincipal()).getEmail();
        List<String> roles = ((UserPrincipalDetails) authResult.getPrincipal())
                .getAuthorities()
                .stream()
                .map(role -> role.getAuthority())
                .collect(Collectors.toList());

        // criar o token
        String token = JwtUtils.createToken(email, roles);
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode jsonTokenBuilder = mapper.createObjectNode();
        jsonTokenBuilder.put("email", email);
        jsonTokenBuilder.put("token", SecurityConstants.TOKEN_PREFIX + " " + token);

        response.getWriter().write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonTokenBuilder));
        response.getWriter().flush(); 

    }
}
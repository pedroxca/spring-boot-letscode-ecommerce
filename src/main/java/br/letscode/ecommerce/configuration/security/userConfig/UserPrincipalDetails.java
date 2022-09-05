package br.letscode.ecommerce.configuration.security.userConfig;

import br.letscode.ecommerce.entity.Cliente;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

//Classe que vai retornar somente o que eh necessario para autenticacao, ao inves de todo o cliente, implementando
//UserDetails do Spring.
public class UserPrincipalDetails implements UserDetails {

    final Cliente cliente;
    Logger logger = LoggerFactory.getLogger(UserPrincipalDetails.class);
    public UserPrincipalDetails(Cliente cliente) {
        logger.debug("THIS IS THE CLIENT" + cliente);
        this.cliente = cliente;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_".concat(cliente.getPerfilEnum().name())));
    }

    @Override
    public String getPassword() {
        return cliente.getSenha();
    }

    @Override
    public String getUsername() {
        return cliente.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getEmail() {
        return cliente.getEmail();
    }
}
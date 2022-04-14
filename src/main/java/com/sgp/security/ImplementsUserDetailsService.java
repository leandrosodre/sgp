package com.sgp.security;


import com.sgp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ImplementsUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(final String login) throws UsernameNotFoundException {
        final com.sgp.models.User user = userRepository.findByLogin(login);

        if (user == null) {
            throw new UsernameNotFoundException("Usuário não encontrado.");
        }
        return new User(user.getUsername(), user.getPassword(), true, true, true, true, user.getAuthorities());
    }

}

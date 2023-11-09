package goit.spring.data.service.security;

import goit.spring.data.dto.security.AuthUser;
import goit.spring.data.entity.User;
import goit.spring.data.repository.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomeUserDetailsService implements UserDetailsService {
    private final UserRepo repo;

    public CustomeUserDetailsService(UserRepo repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User user = repo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User name not found: " + username));
        return new AuthUser(user);
    }
}

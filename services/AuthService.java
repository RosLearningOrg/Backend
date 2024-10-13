package com.ytrewq.rosLearning.Services;

import com.ytrewq.rosLearning.Entities.User;
import com.ytrewq.rosLearning.Repositories.AuthRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {
    private final AuthRepository repo;

    public AuthService(AuthRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found"));
    }

    public Boolean existsByUsername(String username) {
        return repo.existsByUsername(username);
    }

    public Boolean existsByEmail(String email) {
        return repo.existsByEmail(email);
    }

    public void save(User user) {
        repo.save(user);
    }
}
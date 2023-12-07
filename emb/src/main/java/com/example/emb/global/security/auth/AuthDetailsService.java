package com.example.emb.global.security.auth;

import com.example.emb.domain.manager.domain.Manager;
import com.example.emb.domain.manager.domain.repository.ManagerRepository;
import com.example.emb.domain.user.domain.repository.UserRepository;
import com.example.emb.global.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AuthDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final ManagerRepository managerRepository;

    @Override
    public UserDetails loadUserByUsername(String user_id) throws UsernameNotFoundException {

        Optional<Manager> managerOptional = managerRepository.findById(user_id);

        if (managerOptional.isPresent()) {
            return managerRepository.findById(user_id)
                    .map(ManagerAuthDetails::new)
                    .orElseThrow(() -> UserNotFoundException.EXCEPTION);
        } else {
            return userRepository.findByUserId(user_id)
                    .map(AuthDetails::new)
                    .orElseThrow(() -> UserNotFoundException.EXCEPTION);
        }
    }
}

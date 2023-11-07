package com.example.emb.domain.auth.service;

        import com.example.emb.domain.user.domain.User;
        import com.example.emb.domain.user.domain.repository.UserRepository;
        import com.example.emb.global.exception.UserNotFoundException;
        import lombok.RequiredArgsConstructor;
        import org.springframework.security.core.Authentication;
        import org.springframework.security.core.context.SecurityContextHolder;
        import org.springframework.stereotype.Service;
        import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class GetUserInfoService {

    private final UserRepository userRepository;

    public User excute() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String UID = authentication.getName();

        return userRepository.findByUserId(UID)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }
}

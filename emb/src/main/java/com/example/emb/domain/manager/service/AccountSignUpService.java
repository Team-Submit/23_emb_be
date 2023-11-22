package com.example.emb.domain.manager.service;

import com.example.emb.domain.auth.presentation.dto.response.UserTokenResponse;
import com.example.emb.domain.manager.facade.ManagerFacade;
import com.example.emb.domain.manager.presentation.dto.request.ManagerSignUpRequest;
import com.example.emb.domain.user.domain.User;
import com.example.emb.domain.user.domain.repository.UserRepository;
<<<<<<< Updated upstream
import com.example.emb.domain.user.facade.UserFacade;
=======
>>>>>>> Stashed changes
import com.example.emb.global.property.jwt.JwtProperties;
import com.example.emb.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.ZonedDateTime;

@RequiredArgsConstructor
@Service
public class AccountSignUpService {

    private final ManagerFacade managerFacade;
<<<<<<< Updated upstream
    private final UserFacade userFacade;
=======
>>>>>>> Stashed changes
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final JwtProperties jwtProperties;
    private final UserRepository userRepository;

    @Transactional
    public UserTokenResponse execute(ManagerSignUpRequest request) {
        userFacade.checkUserIdExists(request.getId());

        User user = userRepository.save(User.builder()
                .userId(request.getId())
                .userPassword(passwordEncoder.encode(request.getPassword()))
                .build());
        
        String accessToken = jwtTokenProvider.generateAccessToken(user.getUserId());
        String refreshToken = jwtTokenProvider.generateRefreshToken(user.getUserId());
        
        return UserTokenResponse.builder()
                .accessToken(accessToken)
                .expiredAt(ZonedDateTime.now().plusSeconds(jwtProperties.getAccessExp()))
                .refreshToken(refreshToken)
                .build();
    }
}

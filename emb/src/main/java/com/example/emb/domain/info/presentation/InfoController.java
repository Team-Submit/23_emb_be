package com.example.emb.domain.info.presentation;

import com.example.emb.domain.info.presentation.dto.request.CreateInfoRequest;
import com.example.emb.domain.info.service.CreateInfoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/information")
public class InfoController {

    private final CreateInfoService createInfoService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/personals")
    public void createFeed(@RequestBody @Valid CreateInfoRequest request) {
        createInfoService.execute(request);
    }
}

package com.example.emb.domain.info.presentation;

import com.example.emb.domain.info.presentation.dto.request.CreateInfoRequest;
import com.example.emb.domain.info.presentation.dto.response.GetInfoDetailsResponse;
import com.example.emb.domain.info.service.CreateInfoService;
import com.example.emb.domain.info.service.GetInfoDetailsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/information")
public class InfoController {

    private final CreateInfoService createInfoService;
    private final GetInfoDetailsService getInfoDetailsService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/personals")
    public void createFeed(@RequestBody @Valid CreateInfoRequest request) {
        createInfoService.execute(request);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping("/details{id}")
    public GetInfoDetailsResponse getDetails(@PathVariable("id") Long id) {
        return getInfoDetailsService.getDetails(id);
    }
}

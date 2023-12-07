package com.example.emb.domain.info.presentation;

import com.example.emb.domain.info.presentation.dto.request.CreateInfoRequest;
import com.example.emb.domain.info.presentation.dto.response.GetInfoDetailsResponse;
import com.example.emb.domain.info.presentation.dto.response.SearchResponse;
import com.example.emb.domain.info.service.CreateInfoService;
import com.example.emb.domain.info.service.GetInfoDetailsService;
import com.example.emb.domain.info.service.SearchInfoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/information")
public class InfoController {

    private final CreateInfoService createInfoService;
    private final GetInfoDetailsService getInfoDetailsService;
    private final SearchInfoService searchInfoService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/personals")
    public void createFeed(@RequestBody @Valid CreateInfoRequest request) {
        createInfoService.execute(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/search")
    public List<SearchResponse> searchFeed(@RequestParam String name, @RequestParam(required = false) String birthdate) {
        return searchInfoService.execute(name, birthdate);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/details/{term_id}")
    public GetInfoDetailsResponse getDetails(@PathVariable("term_id") Long term_id) {
        return getInfoDetailsService.getDetails(term_id);
    }
}

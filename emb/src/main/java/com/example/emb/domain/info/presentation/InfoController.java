package com.example.emb.domain.info.presentation;

import com.example.emb.domain.info.domain.Terms;
import com.example.emb.domain.info.presentation.dto.request.CreateInfoRequest;
import com.example.emb.domain.info.service.CreateInfoService;
import com.example.emb.domain.info.service.SearchPersonalService;
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
    private final SearchPersonalService searchPersonalService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/personals")
    public void createFeed(@RequestPart @Valid CreateInfoRequest request) {
        createInfoService.execute(request);
    }

    @GetMapping("/search")
    public List<Terms> searchPersonal(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "birthdate", required = false) String birthdate) {
        return searchPersonalService.execute(name, birthdate);
    }
}

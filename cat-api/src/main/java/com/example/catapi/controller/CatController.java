package com.example.catapi.controller;

import com.example.catapi.dto.CatDto;
import com.example.catapi.entity.Cat;
import com.example.catapi.service.CatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cats")
@RequiredArgsConstructor
public class CatController {

    private final CatService catService;

    @PostMapping
    public Cat save(@RequestBody CatDto catDto) {
        return catService.save(catDto);
    }

    @GetMapping
    public List<Cat> getAll() {
        return catService.getAll();
    }
}

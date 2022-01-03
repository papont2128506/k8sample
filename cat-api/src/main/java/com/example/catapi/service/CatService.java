package com.example.catapi.service;

import com.example.catapi.dto.CatDto;
import com.example.catapi.entity.Cat;
import com.example.catapi.repository.CatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CatService {

    private final CatRepository catRepository;

    public Cat save(CatDto catDto) {
        Cat cat = new Cat()
                .setName(catDto.getName())
                .setBirthDay(catDto.getBirthDay())
                .setCreatedAt(LocalDateTime.now());
        return catRepository.save(cat);
    }

    public List<Cat> getAll() {
        return catRepository.findAll();
    }
}

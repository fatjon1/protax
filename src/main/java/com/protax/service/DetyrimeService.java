package com.protax.service;

import com.protax.entity.Detyrime;
import com.protax.repo.DetyrimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetyrimeService {

    private final DetyrimeRepository detyrimeRepository;
    @Autowired
    public DetyrimeService(DetyrimeRepository detyrimeRepository) {
        this.detyrimeRepository = detyrimeRepository;
    }

    public List<Detyrime> getDetyrimet(){
        return detyrimeRepository.findAll();
    }

}

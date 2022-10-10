package com.protax.service;

import com.protax.entity.Fatura;
import com.protax.repo.FaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FaturaService {

    private final FaturaRepository faturaRepository;
    @Autowired
    public FaturaService(FaturaRepository faturaRepository) {
        this.faturaRepository = faturaRepository;
    }

    public List<Fatura> getFaturat(){
        return faturaRepository.findAll();
    }

    public List<Fatura> getFaturaByNid(String nid){
       return faturaRepository.findByNid(nid);
    }

    public Fatura fatura (Long fature_id){
        return faturaRepository.findByKodFature(fature_id);
    }
}

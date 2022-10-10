package com.protax.entity.pagesa;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagesaService {

    private final PagesaRepo pagesaRepo;

    public PagesaService(PagesaRepo pagesaRepo) {
        this.pagesaRepo = pagesaRepo;
    }

    public void createPagesa(Pagesa pagesa){
        pagesaRepo.save(pagesa);

    }

    public List<Pagesa> getPagesat() {
       return pagesaRepo.findAll();
    }
}

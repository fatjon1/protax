package com.protax.controller;

import com.protax.entity.pagesa.PagesaService;
import com.protax.service.FaturaService;
import com.protax.entity.Fatura;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@Api( tags = "Fatura")
public class FaturaController {

    private final FaturaService faturaService;
    private final PagesaService pagesaService;

    @Autowired
    public FaturaController(FaturaService faturaService, PagesaService pagesaService) {
        this.faturaService = faturaService;
        this.pagesaService = pagesaService;
    }

    @GetMapping("/faturat")
    @ApiIgnore
    @ApiOperation(value = "This method is used to get all from faturat.")
    public ResponseEntity<List<Fatura>> getFatura(){
        List<Fatura> faturat = new ArrayList<>(faturaService.getFaturat());
        return new ResponseEntity<>(faturat, HttpStatus.OK);
    }

    @GetMapping("/faturat/{nid}")
    @ApiOperation("The endpoint for getting all the bills for a specific user baset on the personal number (NID) \n")
    public ResponseEntity<?> getFaturaByNid(@PathVariable String nid){
        if (nid.length()==10)
           return new ResponseEntity<>(faturaService.getFaturaByNid(nid), HttpStatus.OK);
        else
            return new ResponseEntity<>("NID nuk eshte i sakte!", HttpStatus.BAD_REQUEST);
    }
}

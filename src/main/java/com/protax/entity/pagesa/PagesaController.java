package com.protax.entity.pagesa;

import com.protax.entity.Fatura;
import com.protax.service.FaturaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
@Api(tags = "Pagesa")
public class PagesaController {

    private final PagesaService pagesaService;
    private final FaturaService faturaService;

    public PagesaController(PagesaService pagesaService, FaturaService faturaService) {
        this.pagesaService = pagesaService;
        this.faturaService = faturaService;
    }
    @ApiIgnore
    @GetMapping("/pagesat")
    public List<Pagesa> getPagesat(){
       return pagesaService.getPagesat();
    }

    @PostMapping("/paguaj/{fature_id}")
    @ApiOperation("The endpoint for creating a new payment for a specific bill providing the bill_id ")
    public ResponseEntity<?> paguaj(@PathVariable Long fature_id) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Fatura fatura = faturaService.fatura(fature_id);
        if (fatura!=null) {
            Pagesa pagesa = new Pagesa();
            pagesa.setFatura_fkey(fatura.getKodFature());
            pagesa.setGjeneruar(LocalDateTime.now());
            pagesa.setVlera(fatura.getDetyrimi());
            pagesa.setKod_pronari(fatura.getPronari().getKod_pronari());
            pagesa.setArketari(auth.getName());
            pagesa.setArketariDetails(auth.getPrincipal().toString());

            if (fatura.getDiferenca() != 0) {
                pagesaService.createPagesa(pagesa);
            } else {
                return new ResponseEntity<>(
                        "Pagesa per kete fature ekziston!",
                        HttpStatus.FORBIDDEN);
            }
        }else
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Nuk ekziston fature me kete id! \n");

        return ResponseEntity.ok().build();
    }
}

package com.protax.repo;

import com.protax.entity.Fatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FaturaRepository extends JpaRepository<Fatura, Long> {
    List<Fatura> findByNid(String nid);

    Fatura findByKodFature(Long kodFature);
}

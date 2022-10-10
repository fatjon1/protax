package com.protax.entity.pagesa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagesaRepo extends JpaRepository<Pagesa,Long> {
}

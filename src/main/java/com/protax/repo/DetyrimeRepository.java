package com.protax.repo;

import com.protax.entity.Detyrime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetyrimeRepository extends JpaRepository<Detyrime, Long> {

}

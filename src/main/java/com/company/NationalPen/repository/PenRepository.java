package com.company.NationalPen.repository;

import com.company.NationalPen.entity.MaterialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PenRepository extends JpaRepository<MaterialEntity, Long> {

}

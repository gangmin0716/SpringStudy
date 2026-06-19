package com.dgsw.school.repository;

import com.dgsw.school.entity.EnrollEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollRepository extends JpaRepository<EnrollEntity, String> {
}
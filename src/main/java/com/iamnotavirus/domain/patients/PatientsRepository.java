package com.iamnotavirus.domain.patients;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PatientsRepository extends JpaRepository<Patient, Long> {

    //SpringDataJpa 제공 기본메소드를 활용해도 되지만 Query가 가독성이 좋음
    @Query("SELECT p FROM Patient p ORDER BY p.id DESC")
    List<Patient> findAllDesc();
}
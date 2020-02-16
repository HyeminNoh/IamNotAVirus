package com.iamnotavirus.web.dto;

import com.iamnotavirus.domain.patients.Patient;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PatientsListResponseDto {
    private Long id;
    private String country;
    private String people;
    private LocalDateTime modifiedDate;

    public PatientsListResponseDto(Patient entity){
        this.id = entity.getId();
        this.country = entity.getCountry();
        this.people = entity.getPeople();
        this.modifiedDate = entity.getModifiedDate();
    }
}

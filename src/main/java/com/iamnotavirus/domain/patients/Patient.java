package com.iamnotavirus.domain.patients;

import com.iamnotavirus.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Patient extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String country;

    private String people;

    @Builder
    public Patient(String country, String people){
        this.country = country;
        this.people = people;
    }

    public void update(String country, String people){
        this.country = country;
        this.people = people;
    }
}

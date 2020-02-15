package com.iamnotavirus.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jsoup.nodes.Element;

@Getter
@NoArgsConstructor
public class Patient {
    String country; // 나라
    String confirmation;   // 확진환자

    @Builder
    public Patient(String country, String confirmation){
        this.country = country;
        this.confirmation = confirmation;
    }

    @Override
    public String toString() {
        return "{" +
                "Country='" + country + '\'' +
                ", Confirmation='" + confirmation + '\'' +
                '}';
    }
}

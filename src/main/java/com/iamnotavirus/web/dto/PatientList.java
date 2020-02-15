package com.iamnotavirus.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public class PatientList {
    private List<Patient> patients = new ArrayList<>();

    public PatientList(Elements element){
        patients.add(new Patient("한국",element.first().select("li").first().text().split(" ")[1]));

        String[] ch = element.get(1).select("li").get(0).text().replace(") ",")/").split("/");
        patients.add(new Patient("중국",ch[1]));

        Elements lists= element.get(1).select("li");
        for(int i=1; i<lists.size()-1; i++){
           String[] values = lists.get(i).text().replace(") ",")/").split("/");
           for(String value : values[1].replace(", ",",").split(",")){
               String[] val = value.split(" ");
               if(val.length==2){
                   patients.add(new Patient(val[0],val[1]));
               }
               else{
                   String patientsNum = "";
                   for(int k=1; k<val.length; k++){
                       patientsNum = patientsNum+val[k];
                   }
                   patients.add(new Patient(val[0],patientsNum));
               }
           }
        }
        String[] etc = lists.get(lists.size()-1).text().replace(") ",")/").split("/");
        patients.add(new Patient("기타", etc[1]));

    }

    @Override
    public String toString() {
        return patients.stream()
                .map(Patient::toString)
                .collect(Collectors.joining(", \n"));
    }
}

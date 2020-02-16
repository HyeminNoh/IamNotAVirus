package com.iamnotavirus.service.patients;

import com.iamnotavirus.domain.patients.PatientsRepository;
import com.iamnotavirus.web.dto.PatientsListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PatientsService {
    private final PatientsRepository patientsRepository;

    @Transactional(readOnly = true)
    public List<PatientsListResponseDto> findAllDesc(){
        return patientsRepository.findAll().stream()
                .map(PatientsListResponseDto::new)
                .collect(Collectors.toList());
    }
}

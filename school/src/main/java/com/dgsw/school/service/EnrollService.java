package com.dgsw.school.service;

import com.dgsw.school.dto.EnrollDTO;
import com.dgsw.school.entity.EnrollEntity;
import com.dgsw.school.repository.EnrollRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class EnrollService {

    private final EnrollRepository enrollRepository;

    public String registerEnroll(EnrollDTO enrollDTO) {
        try {
            EnrollEntity entity = new EnrollEntity(enrollDTO.getSchoolId(), enrollDTO.getSubject());
            enrollRepository.save(entity);
            return "created";
        } catch (Exception e) {
            return "fail";
        }
    }

    public EnrollDTO getEnroll(String studentId) {
        Optional<EnrollEntity> entity = enrollRepository.findById(studentId);
        return entity.map(e -> new EnrollDTO(e.getSchoolId(), e.getSubject())).orElse(null);
    }

    public List<EnrollDTO> getAllEnrolls() {
        return enrollRepository.findAll().stream()
                .map(e -> new EnrollDTO(e.getSchoolId(), e.getSubject()))
                .collect(Collectors.toList());
    }

    public String updateEnroll(EnrollDTO enrollDTO) {
        Optional<EnrollEntity> entity = enrollRepository.findById(enrollDTO.getSchoolId());
        if (entity.isPresent()) {
            EnrollEntity e = entity.get();
            e.setSubject(enrollDTO.getSubject());
            enrollRepository.save(e);
            return "updated";
        }
        return "not found";
    }

    public String deleteEnroll(String id) {
        if (enrollRepository.existsById(id)) {
            enrollRepository.deleteById(id);
            return "deleted";
        }
        return "not found";
    }
}
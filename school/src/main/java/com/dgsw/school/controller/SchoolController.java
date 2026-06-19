package com.dgsw.school.controller;


import com.dgsw.school.dto.EnrollDTO;
import com.dgsw.school.dto.ResponseDTO;
import com.dgsw.school.service.EnrollService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class SchoolController {

    private final EnrollService enrollService;
    @GetMapping("/school/{id}")
    public String getSchool(@PathVariable("id") String id) {
        log.info("학교 ID: " + id);
        return "학교 정보 조회 완료";
    }

    @GetMapping("/student")
    public String getStudent(@RequestParam("studentId") String studentId, @RequestParam("grade") int grade) {
        log.info("학생 ID: " + studentId + ", 학년: " + grade);
        return "학생 정보 조회 완료";
    }

    @PostMapping("/enroll1")
    public String enroll1(@RequestBody String enrollMessage) {
        log.info("요청 본문: " + enrollMessage);
        return "수강신청 처리 완료";
    }

    @PostMapping("/enroll2")
    public ResponseDTO enroll2(@RequestBody EnrollDTO enrollDTO) {
        log.info("학생 ID: " + enrollDTO.getSchoolId() + ", 신청 과목: " + enrollDTO.getSubject());
        return new ResponseDTO("수강신청 완료");
    }

    @PostMapping("/enroll")
    public String registerEnroll(@RequestBody EnrollDTO enrollDTO) {
        log.info("학생 ID: " + enrollDTO.getSchoolId() + ", 신청 과목: " + enrollDTO.getSubject());
        return enrollService.registerEnroll(enrollDTO);
    }

    @GetMapping("/enroll")
    public EnrollDTO getEnroll(@RequestParam String studentId) {
        return enrollService.getEnroll(studentId);
    }

    @GetMapping("/enrolls")
    public List<EnrollDTO> getAllEnrolls() {
        return enrollService.getAllEnrolls();
    }

    @PutMapping("/enroll")
    public String updateEnroll(@RequestBody EnrollDTO enrollDTO) {
        log.info("수정 대상 학생 ID: " + enrollDTO.getSchoolId());
        return enrollService.updateEnroll(enrollDTO);
    }

    @DeleteMapping("/enroll")
    public String deleteEnroll(@RequestParam String id) {
        log.info("삭제 대상 학생 ID: " + id);
        return enrollService.deleteEnroll(id);
    }
}

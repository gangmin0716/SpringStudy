package com.dgsw.school.controller;


import com.dgsw.school.dto.EnrollDTO;
import com.dgsw.school.dto.ResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class SchoolController {
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
}

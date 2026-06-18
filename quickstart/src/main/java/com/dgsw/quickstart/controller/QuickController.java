package com.dgsw.quickstart.controller;

import com.dgsw.quickstart.dto.ItemDTO;
import com.dgsw.quickstart.dto.ResponseDTO;
import com.dgsw.quickstart.service.QuickService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class QuickController {
    @Autowired
    private QuickService quickService;
    @GetMapping("/dummy1")
    public String dummy1(){
        log.info("dummy1");
        return "{}";
    }

    @GetMapping("/dummy2")
    public String dummy2() {
        log.info("dummy2");
        return "dummy2";
    }
    @GetMapping("/member")
    public String getMember(@RequestParam("empNo") String empNo, @RequestParam("year") int year) {
        log.info("empNo:{}", empNo);
        log.info("year:{}", year);
        return "ok";
    }

    @GetMapping("/company/{id}")
    public String getCompany(@PathVariable("id") String id) {
        log.info("id:{}", id);
        return "ok";
    }

    @PostMapping("/item1")
    public String registerItem1(@RequestBody String item) {
        log.info("item:{}", item);
        return "ok";
    }

    @PostMapping("/item2")
    public ResponseDTO registerItem2(@RequestBody @Valid ItemDTO item) {
        log.info("itemId:{}", item.getId());
        log.info("itemName:{}", item.getName());
        boolean created = quickService.registerItem(item);
        return new ResponseDTO("ok");
    }
}
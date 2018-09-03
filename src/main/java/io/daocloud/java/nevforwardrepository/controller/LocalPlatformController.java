package io.daocloud.java.nevforwardrepository.controller;

import io.daocloud.java.nevforwardrepository.entity.ForwardLocalRecord;
import io.daocloud.java.nevforwardrepository.repository.ForwardLocalRecordRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/test")
public class LocalPlatformController {

    @Autowired
    private ForwardLocalRecordRepository forwardLocalRecordRepository;

    @GetMapping
    public List<ForwardLocalRecord> test() throws ParseException {
        try {
            LocalDateTime start_date = LocalDateTime.of(2017,9,19,0,0,0);
            LocalDateTime end_date = LocalDateTime.of(2017,9,25,0,0,0);
            return forwardLocalRecordRepository.findAllBySendTimeBetweenAndVinAndPlatformVin(start_date,end_date,"58308F2DF965423C8","58308f2df965423c8");
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
}
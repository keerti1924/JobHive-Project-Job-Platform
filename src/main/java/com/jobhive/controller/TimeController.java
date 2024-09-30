package com.jobhive.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jobhive.Utils.TimeUtils;

@RestController
public class TimeController {

    @GetMapping("/time-ago")
    public String getTimeAgo(@RequestParam("date") String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME.withZone(ZoneId.systemDefault());
        LocalDateTime dateTime = LocalDateTime.parse(dateString, formatter);
        return TimeUtils.formatRelativeTime(dateTime);
    }
}
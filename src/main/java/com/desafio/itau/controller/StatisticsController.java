package com.desafio.itau.controller;

import com.desafio.itau.entity.Statistics;
import com.desafio.itau.service.StatisticService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statistics")
@AllArgsConstructor
public class StatisticsController {

    private final StatisticService statisticService;

    @GetMapping
    public ResponseEntity<Statistics> Statistics() {
        return ResponseEntity.ok(statisticService.Statistics());
    }
}

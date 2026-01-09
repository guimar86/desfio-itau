package com.desafio.itau.service;

import com.desafio.itau.config.StatsConfiguration;
import com.desafio.itau.entity.Statistics;
import com.desafio.itau.entity.Transaction;
import com.desafio.itau.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StatisticService {

    private final TransactionRepository transactionRepository;
    private final StatsConfiguration statsConfig;

    public Statistics Statistics() {

        List<Transaction> transactions = transactionRepository.findDataHoraAfter(statsConfig.minutes());

        Long count = (long) transactions.size();

        List<BigDecimal> values = transactions.stream()
                .map(Transaction::getValor)
                .filter(Objects::nonNull)
                .toList();

        BigDecimal average = values.isEmpty()
                ? BigDecimal.ZERO
                : values.stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(
                        BigDecimal.valueOf(values.size()),
                        2, RoundingMode.HALF_UP);


        var sum = transactions.stream()
                .map(Transaction::getValor)
                .filter(Objects::nonNull)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        Optional<BigDecimal> min = transactions.stream()
                .map(Transaction::getValor)
                .filter(Objects::nonNull)
                .min(BigDecimal::compareTo);

        Optional<BigDecimal> max = transactions.stream()
                .map(Transaction::getValor)
                .filter(Objects::nonNull)
                .max(BigDecimal::compareTo);

        return new Statistics(count, sum, average, max.orElse(BigDecimal.ZERO), min.orElse(BigDecimal.ZERO));
    }
}

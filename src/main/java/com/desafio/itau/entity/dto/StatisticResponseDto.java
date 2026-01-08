package com.desafio.itau.entity.dto;

import java.math.BigDecimal;

public record StatisticResponseDto(Long count, BigDecimal sum, BigDecimal average, BigDecimal min, BigDecimal max) {
}

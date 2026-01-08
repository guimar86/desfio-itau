package com.desafio.itau.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Statistics {

    private Long count;
    private BigDecimal sum;
    private BigDecimal average;
    private BigDecimal max;
    private BigDecimal min;

}

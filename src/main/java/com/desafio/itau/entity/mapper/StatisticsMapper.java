package com.desafio.itau.entity.mapper;

import com.desafio.itau.entity.Statistics;
import com.desafio.itau.entity.dto.StatisticResponseDto;

public class StatisticsMapper {

    public static Statistics toEntity(StatisticResponseDto dto) {
        return new Statistics(dto.count(), dto.sum(), dto.average(), dto.min(), dto.max());
    }

    public static StatisticResponseDto toDto(Statistics statistics) {
        return new StatisticResponseDto(statistics.getCount(), statistics.getSum(), statistics.getAverage(), statistics.getMin(), statistics.getMax());
    }
}

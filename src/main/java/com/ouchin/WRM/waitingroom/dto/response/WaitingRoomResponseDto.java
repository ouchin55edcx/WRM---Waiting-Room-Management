package com.ouchin.WRM.waitingroom.dto.response;

import com.ouchin.WRM.waitingroom.entity.enums.Algorithm;
import com.ouchin.WRM.waitingroom.entity.enums.Mode;

import java.time.LocalDate;

public class WaitingRoomResponseDto {
    private int id;
    private LocalDate date;
    private Integer capacity;
    private Mode mode;
    private Algorithm algorithm;
    private List<VisitResponseDto> visits;
}

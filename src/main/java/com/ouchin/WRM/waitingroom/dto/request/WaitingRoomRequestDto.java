package com.ouchin.WRM.waitingroom.dto.request;

import com.ouchin.WRM.waitingroom.entity.enums.Algorithm;
import com.ouchin.WRM.waitingroom.entity.enums.Mode;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class WaitingRoomRequestDto {

    @NotNull
    private LocalDate date;

    @NotNull
    private Integer capacity;

    @NotNull
    private Mode mode;

    private Algorithm algorithm;
}

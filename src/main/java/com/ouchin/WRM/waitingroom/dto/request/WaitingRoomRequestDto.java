package com.ouchin.WRM.waitingroom.dto.request;

import com.ouchin.WRM.waitingroom.entity.enums.Algorithm;
import com.ouchin.WRM.waitingroom.entity.enums.Mode;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class WaitingRoomRequestDto {
    @NotNull(message = "Date is required")
    private LocalDate date;

    @NotNull(message = "Capacity is required")
    private Integer capacity;

    @NotNull(message = "Mode is required")
    private Mode mode;

    @NotNull(message = "Algorithm is required")
    private Algorithm algorithm;

}

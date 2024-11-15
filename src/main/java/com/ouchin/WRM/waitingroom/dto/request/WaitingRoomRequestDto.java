package com.ouchin.WRM.waitingroom.dto.request;

import com.ouchin.WRM.waitingroom.entity.enums.Algorithm;
import com.ouchin.WRM.waitingroom.entity.enums.Mode;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class WaitingRoomRequestDto {
    @NotNull(message = "Date is required")
    private String date;

    @NotNull(message = "Capacity is required")
    @Min(value = 1, message = "Capacity must be at least 1")
    private Integer capacity;

    @NotNull(message = "Mode is required")
    private Mode mode;

    @NotNull(message = "Algorithm is required")
    private Algorithm algorithm;
}

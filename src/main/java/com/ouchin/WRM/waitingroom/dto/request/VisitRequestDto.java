package com.ouchin.WRM.waitingroom.dto.request;

import com.ouchin.WRM.waitingroom.entity.enums.Status;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.Duration;
import java.time.LocalTime;

public class VisitRequestDto {
    @NotNull(message = "Arrival time is required")
    private LocalTime arrivalTime;

    @NotNull
    private LocalTime startTime;

    @NotNull
    private LocalTime endTime;

    @NotNull
    private Status status;

    @NotNull
    @Min(value = 0, message = "Priority must be between 1 and 255")
    @Max(value = 255, message = "Priority must be between 1 and 255")
    private Byte priority;

    @NotNull
    @Positive
    private Duration estimatedProcessingTime;

    @NotNull
    private Long visitorId;

    @NotNull
    private Integer waitingRoomId;
}

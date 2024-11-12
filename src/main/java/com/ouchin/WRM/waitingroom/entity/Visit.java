package com.ouchin.WRM.waitingroom.entity;

import com.ouchin.WRM.visitor.entity.Visitor;
import com.ouchin.WRM.waitingroom.entity.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import com.ouchin.  ;;

import java.time.Duration;
import java.time.LocalTime;

@Entity
public class Visit {

    @Embedded
    private VisitId id;

    @NotNull(message = "Arrival time is required")
    private LocalTime arrivalTime;

    private LocalTime startTime;

    private LocalTime endTime;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Status is required")
    private Status status;

    private Byte priority;

    private Duration estimatedProcessingTime;

    @ManyToOne
    @JoinColumn(name = "visitor_id", insertable = false, updatable = false)
    private Visitor visitor;

    @ManyToOne
    @JoinColumn(name = "waiting_room_id", insertable = false, updatable = false)
    private WaitingRoom waitingRoom;
}

package com.ouchin.WRM.waitingroom.entity;

import com.ouchin.WRM.visitor.entity.Visitor;
import com.ouchin.WRM.waitingroom.Embedded.VisitId;
import com.ouchin.WRM.waitingroom.entity.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.Duration;
import java.time.LocalTime;

@Entity
public class Visit {

    @EmbeddedId
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

    @MapsId("visitorId")
    @ManyToOne
    @JoinColumn(name = "visitor_id", nullable = false)
    private Visitor visitor;

    @MapsId("waitingRoomId")
    @ManyToOne
    @JoinColumn(name = "waiting_room_id", nullable = false)
    private WaitingRoom waitingRoom;
}

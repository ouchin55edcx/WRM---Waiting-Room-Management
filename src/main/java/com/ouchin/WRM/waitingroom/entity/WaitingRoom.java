package com.ouchin.WRM.waitingroom.entity;

import com.ouchin.WRM.waitingroom.entity.enums.Algorithm;
import com.ouchin.WRM.waitingroom.entity.enums.Mode;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class WaitingRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Date is required")
    private LocalDate date;

    @NotNull(message = "Capacity is required")
    private Integer capacity;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Mode is required")
    private Mode mode;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Algorithm is required")
    private Algorithm algorithm;

    @OneToMany(mappedBy = "waitingRoom")
    private List<Visit> visits = new ArrayList<>();
}

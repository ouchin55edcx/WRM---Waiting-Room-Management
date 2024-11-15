package com.ouchin.WRM.waitingroom.dto.response;

import com.ouchin.WRM.waitingroom.entity.enums.Algorithm;
import com.ouchin.WRM.waitingroom.entity.enums.Mode;
import lombok.Data;

import java.util.List;

@Data
public class WaitingRoomResponseDto {
    private Long id;
    private String date;
    private Integer capacity;
    private Mode mode;
    private Algorithm algorithm;
    private List<VisitResponseDto> visits;
}

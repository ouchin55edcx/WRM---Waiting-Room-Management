package com.ouchin.WRM.waitingroom.mapper;

import com.ouchin.WRM.waitingroom.dto.request.WaitingRoomRequestDto;
import com.ouchin.WRM.waitingroom.dto.response.WaitingRoomResponseDto;
import com.ouchin.WRM.waitingroom.entity.WaitingRoom;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", uses = VisitMapper.class, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface WaitingRoomMapper {

    WaitingRoom toEntity(WaitingRoomRequestDto dto);

    WaitingRoomResponseDto toResponseDto(WaitingRoom waitingRoom);
}

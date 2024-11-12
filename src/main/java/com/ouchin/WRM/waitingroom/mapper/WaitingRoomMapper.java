package com.ouchin.WRM.waitingroom.mapper;

import com.ouchin.WRM.waitingroom.dto.request.WaitingRoomRequestDto;
import com.ouchin.WRM.waitingroom.dto.response.WaitingRoomResponseDto;
import com.ouchin.WRM.waitingroom.entity.WaitingRoom;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = VisitMapper.class)
public interface WaitingRoomMapper {
    WaitingRoomResponseDto toDto(WaitingRoom waitingRoom);
    WaitingRoom toEntity(WaitingRoomRequestDto waitingRoomRequestDto);
    void updateWaitingRoomFromDto(WaitingRoomRequestDto waitingRoomRequestDto, @MappingTarget WaitingRoom waitingRoom);
}


package com.ouchin.WRM.waitingroom.mapper;

import com.ouchin.WRM.waitingroom.dto.request.WaitingRoomRequestDto;
import com.ouchin.WRM.waitingroom.dto.response.WaitingRoomResponseDto;
import com.ouchin.WRM.waitingroom.entity.WaitingRoom;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = VisitMapper.class)
public interface WaitingRoomMapper {

    WaitingRoomMapper INSTANCE = Mappers.getMapper(WaitingRoomMapper.class);

    @Mapping(target = "id", source = "id.id")
    WaitingRoomResponseDto toDto(WaitingRoom waitingRoom);

    @Mapping(target = "id", ignore = true)
    WaitingRoom toEntity(WaitingRoomRequestDto dto);

    List<WaitingRoomResponseDto> toDtoList(List<WaitingRoom> waitingRooms);
}

package com.ouchin.WRM.waitingroom.mapper;

import com.ouchin.WRM.waitingroom.dto.request.VisitRequestDto;
import com.ouchin.WRM.waitingroom.dto.response.VisitResponseDto;
import com.ouchin.WRM.waitingroom.entity.Visit;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface VisitMapper {
    Visit toEntity(VisitRequestDto dto);
    VisitResponseDto toDto(Visit visit);
}


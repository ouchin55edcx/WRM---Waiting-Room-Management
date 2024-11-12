package com.ouchin.WRM.waitingroom.mapper;

import com.ouchin.WRM.waitingroom.dto.request.VisitRequestDto;
import com.ouchin.WRM.waitingroom.dto.response.VisitResponseDto;
import com.ouchin.WRM.waitingroom.entity.Visit;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface VisitMapper {
    VisitResponseDto toDto(Visit visit);
    Visit toEntity(VisitRequestDto visitRequestDto);
    void updateVisitFromDto(VisitRequestDto visitRequestDto, @MappingTarget Visit visit);
}

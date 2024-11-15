package com.ouchin.WRM.waitingroom.mapper;

import com.ouchin.WRM.waitingroom.dto.request.VisitRequestDto;
import com.ouchin.WRM.waitingroom.dto.response.VisitResponseDto;
import com.ouchin.WRM.waitingroom.entity.Visit;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VisitMapper {

    VisitResponseDto toResponseDto(Visit visit);

    Visit toEntity(VisitRequestDto dto);

}

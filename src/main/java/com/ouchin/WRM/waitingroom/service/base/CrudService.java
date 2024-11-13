package com.ouchin.WRM.waitingroom.service.base;

import java.util.List;

public interface CrudService<Id, RequestDto, ResponseDto> {

    List<ResponseDto> findAll();
    ResponseDto findById(Id id);
    ResponseDto create(RequestDto dto);
    ResponseDto update(Id id, RequestDto dto);
    void delete(Id id);
}

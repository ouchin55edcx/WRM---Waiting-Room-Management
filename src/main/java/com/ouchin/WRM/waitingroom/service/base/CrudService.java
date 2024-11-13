package com.ouchin.WRM.waitingroom.service.base;

import org.springframework.data.domain.Page;

public interface CrudService<Id, REQUEST_DTO, RESPONSE_DTO> {

    Page<RESPONSE_DTO> findAll(int pageNum, int pageSize);
    RESPONSE_DTO findById(Id id);
    RESPONSE_DTO create(REQUEST_DTO dto);
    RESPONSE_DTO update(Id id, REQUEST_DTO dto);
    void delete(Id id);
}

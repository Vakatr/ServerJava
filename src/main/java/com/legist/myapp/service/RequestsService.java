package com.legist.myapp.service;


import com.legist.myapp.domain.Requests;
import com.legist.myapp.dto.RequestDto;

import java.util.List;

public interface RequestsService {
    Requests createRequest(RequestDto requestDto);
    List<RequestDto> getAllRequest(String filter, String id);
    Requests updateRequest(Requests RequestFromDb, Requests requests);
    Requests findById(Long id);
}

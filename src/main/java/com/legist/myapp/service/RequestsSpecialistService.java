package com.legist.myapp.service;



import com.legist.myapp.domain.RequestsSpecialist;
import com.legist.myapp.dto.RequestSpecialistDto;

import java.util.List;

public interface RequestsSpecialistService {
    RequestsSpecialist createRequest(RequestSpecialistDto requestDto);
    List<RequestSpecialistDto> getAllRequest(String filter, String id);
    RequestsSpecialist updateRequest(RequestsSpecialist RequestFromDb, RequestsSpecialist requests);
    RequestsSpecialist findById(Long id);
}

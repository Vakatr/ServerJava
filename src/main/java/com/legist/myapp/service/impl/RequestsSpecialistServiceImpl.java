package com.legist.myapp.service.impl;


import com.legist.myapp.domain.RequestsSpecialist;
import com.legist.myapp.dto.RequestSpecialistDto;
import com.legist.myapp.exceptions.UserNotFoundException;
import com.legist.myapp.repository.RequestSpecialistRepository;
import com.legist.myapp.repository.UserDetailsRepository;
import com.legist.myapp.service.RequestsSpecialistService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RequestsSpecialistServiceImpl implements RequestsSpecialistService {

    private final RequestSpecialistRepository requestRepository;
    private final UserDetailsRepository userDetailsRepository;


    @Autowired
    public RequestsSpecialistServiceImpl(UserDetailsRepository userDetailsRepository,
                                         RequestSpecialistRepository requestRepository) {
        this.requestRepository = requestRepository;
        this.userDetailsRepository = userDetailsRepository;
    }


    @Override
    public RequestsSpecialist createRequest(RequestSpecialistDto requestDto) {
        RequestsSpecialist requestsSpecialist = new RequestsSpecialist();
        requestsSpecialist.setRequestText(requestDto.getRequest_text());
        requestsSpecialist.setCreated(LocalDateTime.now());
        requestsSpecialist.setStatus("Заявка");
        requestsSpecialist.setDecision(requestDto.getDecision());
        requestsSpecialist.setFile(requestDto.getFile());
        requestsSpecialist.setUserId(userDetailsRepository.findByName(requestDto.getUserId().getName()));
        return requestRepository.save(requestsSpecialist);
    }

    @Override
    public List<RequestSpecialistDto> getAllRequest(String filter, String id) {
        List<RequestSpecialistDto> requestDtoList = null;
        if (filter.equals("ADMIN")) {
            requestDtoList=  requestRepository.findAll()
                .stream()
                .map(RequestSpecialistDto::fromRequest)
                .collect(Collectors.toList());
        }
        else {
            requestDtoList=  requestRepository.findUserRequestsSpecialist(id)
                    .stream()
                    .map(RequestSpecialistDto::fromRequest)
                    .collect(Collectors.toList());
        }
        return requestDtoList;
    }

    @Override
    public RequestsSpecialist updateRequest(RequestsSpecialist RequestFromDb, RequestsSpecialist requests) {
        BeanUtils.copyProperties(requests, RequestFromDb, "id","created","userId");
        return requestRepository.save(RequestFromDb);
    }

    @Override
    public RequestsSpecialist findById(Long id) {
        return requestRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }
}

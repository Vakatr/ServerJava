package com.legist.myapp.service.impl;


import com.legist.myapp.domain.Requests;
import com.legist.myapp.dto.NewsDto;
import com.legist.myapp.dto.RequestDto;
import com.legist.myapp.dto.UserDto;
import com.legist.myapp.exceptions.UserNotFoundException;
import com.legist.myapp.repository.NewsRepository;
import com.legist.myapp.repository.RequestRepository;
import com.legist.myapp.repository.UserDetailsRepository;
import com.legist.myapp.service.NewsService;
import com.legist.myapp.service.RequestsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RequestsServiceImpl implements RequestsService {

    private final RequestRepository requestRepository;
    private final UserDetailsRepository userDetailsRepository;


    @Autowired
    public RequestsServiceImpl(UserDetailsRepository userDetailsRepository,
                               RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
        this.userDetailsRepository = userDetailsRepository;
    }


    @Override
    public Requests createRequest(RequestDto requestDto) {
        Requests requests = new Requests();
        requests.setRequesttext(requestDto.getRequest_text());
        requests.setMeetingtime(requestDto.getMeeting_time());
        requests.setCreated(LocalDateTime.now());
        requests.setStatus(1);
        requests.setDecision(requestDto.getDecision());
        requests.setFile(requestDto.getFile());
        requests.setUserId(userDetailsRepository.findByName(requestDto.getUserId().getName()));
        requests.setUserSpecialistId(userDetailsRepository.findByName(requestDto.getUserSpecialistId().getName()));
        return requestRepository.save(requests);
    }

    @Override
    public List<RequestDto> getAllRequest(String filter, String id) {
        List<RequestDto> requestDtoList = null;
        if (filter.equals("ADMIN")) {
            requestDtoList=  requestRepository.findAll()
                .stream()
                .map(RequestDto::fromRequest)
                .collect(Collectors.toList());
        }
        else if (filter.equals("LEGIST")) {
            requestDtoList=  requestRepository.findLegistRequests(id)
                    .stream()
                    .map(RequestDto::fromRequest)
                    .collect(Collectors.toList());
        }
        else if (filter.equals("USER")) {
            requestDtoList=  requestRepository.findUserRequests(id)
                    .stream()
                    .map(RequestDto::fromRequest)
                    .collect(Collectors.toList());
        }
        return requestDtoList;
    }

    @Override
    public Requests updateRequest(Requests RequestFromDb, Requests requests) {
        BeanUtils.copyProperties(requests, RequestFromDb, "id","created","userId","userSpecialistId");
        return requestRepository.save(RequestFromDb);
    }

    @Override
    public Requests findById(Long id) {
        return requestRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }
}

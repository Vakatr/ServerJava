package com.legist.myapp.controller;

import com.legist.myapp.domain.Requests;
import com.legist.myapp.domain.RequestsSpecialist;
import com.legist.myapp.dto.RequestDto;
import com.legist.myapp.dto.RequestSpecialistDto;
import com.legist.myapp.dto.UserDto;
import com.legist.myapp.repository.RequestRepository;
import com.legist.myapp.repository.RequestSpecialistRepository;
import com.legist.myapp.service.RequestsService;
import com.legist.myapp.service.RequestsSpecialistService;
import com.legist.myapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


@RestController
@RequestMapping(value = "/api/v1/legist/")
public class RequestLegistRestController {

    private final UserService userService;
    private final RequestsSpecialistService requestsService;
    private final RequestSpecialistRepository requestRepository;

    @Autowired
    public RequestLegistRestController(UserService userService,
                                       RequestsSpecialistService requestsService,
                                       RequestSpecialistRepository requestRepository) {
        this.userService = userService;
        this.requestsService = requestsService;
        this.requestRepository = requestRepository;
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<RequestSpecialistDto>> getAll(@AuthenticationPrincipal Principal principal) {
        UserDto userDto = UserDto.fromUser(userService.findByName(principal.getName()));
        List<RequestSpecialistDto> result = requestsService.getAllRequest(userDto.getRoles().get(0),userDto.getId());
        return result.size() != 0 ? new ResponseEntity<>(result, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/create")
    @PreAuthorize("hasAnyAuthority('USER')")
    public ResponseEntity<RequestSpecialistDto> create(@RequestBody RequestSpecialistDto requestDto, @AuthenticationPrincipal Principal principal) {
        UserDto userDto = UserDto.fromUser(userService.findByName(principal.getName()));
        requestDto.setUserId(userDto);
        requestDto = requestDto.fromRequest(requestsService.createRequest(requestDto));
        return requestDto.getId() != null ? new ResponseEntity<>(requestDto, HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<RequestSpecialistDto> update(@PathVariable("id") RequestsSpecialist requestFromDb,
                                             @RequestBody RequestsSpecialist requests) {
        RequestSpecialistDto result = RequestSpecialistDto.fromRequest(requestsService.updateRequest(requestFromDb, requests));
        return result.getId() != null ? new ResponseEntity<RequestSpecialistDto>(result, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

/*    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        News news = newsRepository.getOne(id);
        newsRepository.delete(news);
        return new ResponseEntity(HttpStatus.OK);
    }*/
}

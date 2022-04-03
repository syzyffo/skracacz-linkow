package com.syzyffo.linkshortener.controller;

import com.syzyffo.linkshortener.link.LinkAlreadyExistsException;
import com.syzyffo.linkshortener.link.LinkDto;
import com.syzyffo.linkshortener.link.LinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/links")
public class LinkManageController {

    private LinkService service;

    LinkManageController(LinkService service){
        this.service = service;
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<? extends Record> createLink(@RequestBody CreateLinkDto link){
        try{
            LinkDto linkDto = link.toDto();
            return ResponseEntity
                    .created(URI.create(linkDto.getShortenedLink()))
                    .body(service.createLink(linkDto));
        } catch (LinkAlreadyExistsException e){
            return  ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(new ExceptionResponse(e.getMessage()));

        }

    }

    @DeleteMapping("/{id}/{email}")
    ResponseEntity <?> deleteLink(String id, String email){
        return ResponseEntity.noContent().build();
    }


}

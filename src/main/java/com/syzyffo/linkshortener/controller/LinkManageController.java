package com.syzyffo.linkshortener.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/links")
public class LinkManageController {

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    LinkDto createLink(@RequestBody CreateLinkDto link){
        return link.toDto();
    }

}

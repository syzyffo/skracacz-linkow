package com.syzyffo.linkshortener.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/s")
public class RedirectController {

    @GetMapping("/{id}")
    public void redirectLink(
            @PathVariable String id, HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.sendRedirect("https://github.com/syzyffo/skracacz-linkow");
    }
}



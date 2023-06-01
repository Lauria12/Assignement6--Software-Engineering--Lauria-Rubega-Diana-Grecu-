package com.example.assignement6sebook;

import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServletVersionController {

    @Autowired
    ServletContext servletContext;

    @GetMapping("/servlet-version")
    public String getServletVersion() {
        return servletContext.getEffectiveMajorVersion() + "." + servletContext.getEffectiveMinorVersion();
    }
}

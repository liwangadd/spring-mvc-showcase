package com.liwang.sample.mvc.mapping;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Nikolas on 2015/10/23.
 */
@RestController
@RequestMapping("/mapping/*")
public class ClasslevelMappingController {

    @RequestMapping("/path")
    public String byPath() {
        return "Mapped by path";
    }

    @RequestMapping(value = "path/*", method = RequestMethod.GET)
    public String byPathPattren(HttpServletRequest request) {
        return "Mapped by path pattern ('" + request.getRequestURL() + "')";
    }

    @RequestMapping(value = "/method", method = RequestMethod.GET)
    public String byMethod() {
        return "Mapped by path + method";
    }

    @RequestMapping(value = "/parameter", method = RequestMethod.GET, params = "foo")
    public String byParameter() {
        return "Mapped by path + method + presence of query parameter";
    }

    @RequestMapping(value = "/parameter", method = RequestMethod.GET, params = "!foo")
    public String byParameterNegation() {
        return "Mapped by path + method + not presence of query!";
    }

    @RequestMapping(value = "/header", method = RequestMethod.GET, headers = "FooHeader=foo")
    public String byHeader() {
        return "Mapped by path + method + presence of header";
    }

    @RequestMapping(value = "/notheader", method = RequestMethod.GET, headers = "!FooHeader")
    public String byHeaderNegation() {
        return "Mapped by path + method + absence of header";
    }

    @RequestMapping(value = "/consumes", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String byConsume(@RequestBody JavaBean javaBean) {
        return "Mapped by path + method + consumable media type (javaBean '" + javaBean + "')";
    }

    @RequestMapping(value = "/produces", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public JavaBean byProduces() {
        return new JavaBean();
    }

    @RequestMapping(value = "/produces", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    public JavaBean byProducesXml() {
        return new JavaBean();
    }

}

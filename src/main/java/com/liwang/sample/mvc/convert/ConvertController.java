package com.liwang.sample.mvc.convert;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Date;

/**
 * Created by Nikolas on 2015/10/23.
 */
@RestController
@RequestMapping("/convert")
public class ConvertController {

    @RequestMapping("primitive")
    public String primitive(@RequestParam Integer value) {
        return "Converted primitive " + value;
    }

    @RequestMapping("date/{value}")
    public String date(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date value) {
        return "Converted date " + value;
    }

    @RequestMapping("collection")
    public String collection(@RequestParam Collection<Integer> values) {
        return "Converted collection " + values;
    }

    @RequestMapping("formattedCollection")
    public String formattedCollection(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                      Collection<Date> values) {
        return "Converted formatted collection " + values;
    }

    @RequestMapping("custom")
    public String customConverter(@RequestParam @MaskFormat("###-##-####") String value) {
        return "Converted '" + value + "' with a custom converter";
    }

    @RequestMapping("value")
    public String valueObject(@RequestParam SocialSecurityNumber value) {
        return "Converted value object " + value;
    }

    @RequestMapping("bean")
    public String bean(JavaBean bean) {
        return "Converted " + bean;
    }

}

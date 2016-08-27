package com.yope.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author yope
 * @version 1.0.0
 * @date 16/08/27 02:34.
 * @github https://github.com/amazeyope
 */

@RestController
public class HelloController {

    @ApiIgnore
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index() {
        return "Hello World";
    }

}
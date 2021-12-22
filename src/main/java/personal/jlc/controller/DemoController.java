package personal.jlc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import personal.jlc.config.DemoProperties;
import personal.jlc.model.AppQO;

/**
 * @author kelvin
 */
@RestController
@RequestMapping("/demo")
@Slf4j
public class DemoController {

    @Autowired
    private DemoProperties demoProperties;

    @GetMapping("hello")
    public DemoProperties Hello() {
        return demoProperties;
    }

    @PostMapping("post")
    public String getAppQO(@RequestBody AppQO appQO) {
        log.debug(appQO.toString());
        return "";
    }

    @PostMapping("post2")
    public AppQO getAppQO2(@RequestBody AppQO appQO) {
        log.debug(appQO.toString());
        return appQO;
    }
}

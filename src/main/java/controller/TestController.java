package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by magenta9 on 2017/3/1.
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @ResponseBody
    public String hello() {
        return "/view/Hello.html";
    }
}

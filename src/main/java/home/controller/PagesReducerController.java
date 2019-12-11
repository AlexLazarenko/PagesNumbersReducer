package home.controller;

import home.utils.Utils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PagesReducerController {

    Utils utils = new Utils();

    @GetMapping("/reducedPageNumbers")
    public StringBuilder reduce(@RequestParam("rawPageNumbers") String a) {
        return utils.reduce(a);
    }
}


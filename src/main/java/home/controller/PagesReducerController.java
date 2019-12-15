package home.controller;

import home.utils.Utils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * controller class using to provide HTTP endpoint
 */
@RestController
public class PagesReducerController {

    Utils utils = new Utils();

    @GetMapping("/reducedPageNumbers")
    public StringBuilder reduceIgnoringReplications(@RequestParam("rawPageNumbers") String inputData) {
        return utils.reduceIgnoringReplications(inputData);
    }
}


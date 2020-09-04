package ua.mishko.training.webhosting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.mishko.training.webhosting.domain.Request;
import ua.mishko.training.webhosting.repository.RequestRepository;
import ua.mishko.training.webhosting.service.RequestService;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    private final RequestService requestService;

    @Autowired
    public MainController(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping("/")
    public String greeting(Model model,
                           @RequestParam(required = false, defaultValue = "0") Long limit
                           ) {

        List<Request> requestList = requestService.getRequestsList(limit);
        model.addAttribute("requestList",requestList);

        Map<Long,String> averageTime = requestService.getAverageResponseTime(requestList);
        model.addAttribute("average",averageTime);

        model.addAttribute("total",requestService.getAllRequest().size());
        model.addAttribute("size",requestList.size());

        return "main";
    }
}

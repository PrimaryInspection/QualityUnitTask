package ua.mishko.training.webhosting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.mishko.training.webhosting.domain.Request;
import ua.mishko.training.webhosting.service.*;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {

   private final RequestService requestService;
   private final CategoryService categoryService;
   private final QuestionService questionService;
   private final ServiceTypeService serviceTypeService;
   private final SubCategoryService subCategoryService;
   private final VariationService variationService;

   @Autowired
    public MainController(RequestService requestService, CategoryService categoryService, QuestionService questionService, ServiceTypeService serviceTypeService, SubCategoryService subCategoryService, VariationService variationService) {
        this.requestService = requestService;
        this.categoryService = categoryService;
        this.questionService = questionService;
        this.serviceTypeService = serviceTypeService;
        this.subCategoryService = subCategoryService;
        this.variationService = variationService;
    }

    @GetMapping("/")
    public String getRequests(Model model,
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

    @GetMapping("/addRequest")
    public String getAddRequestPage(Model model){

       model.addAttribute("categoryList",categoryService.getCategories());
       model.addAttribute("questionList",questionService.getQuestions());
       model.addAttribute("serviceList",serviceTypeService.getServices());
       model.addAttribute("subCategoryList",subCategoryService.getSubCategories());
       model.addAttribute("variationList",variationService.getVariations());

        return "addRequest";
    }
    @PostMapping("/addRequest")
    public String addRequest(Request request) {
        requestService.saveRequest(request);
        return "redirect:/";
    }
}

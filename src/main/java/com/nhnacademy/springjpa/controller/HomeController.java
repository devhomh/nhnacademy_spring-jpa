package com.nhnacademy.springjpa.controller;

import com.nhnacademy.springjpa.domain.ProductDto;
import com.nhnacademy.springjpa.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String home(ModelMap modelMap,
                       @PageableDefault(size = 6) Pageable pageable) {

        Page<ProductDto> pageResult = productService.getAllBy(pageable);

        int currentPageNumber = pageResult.getNumber();
        Pageable prevPage = currentPageNumber > 0
                ? pageable.previousOrFirst()
                : null;
        Pageable nextPage = currentPageNumber < pageResult.getTotalPages() - 1
                ? pageable.next()
                : null;

        modelMap.addAttribute("products", pageResult.getContent());
        modelMap.addAttribute("totalPage", pageResult.getTotalPages() - 1);
        modelMap.addAttribute("prevPage", prevPage);
        modelMap.addAttribute("nextPage", nextPage);

        return "index";
    }
}

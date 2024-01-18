package com.nhnacademy.springjpa.controller;

import com.nhnacademy.springjpa.domain.ProductDto;
import com.nhnacademy.springjpa.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
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

    private void pageSetting(Pageable pageable, Page<ProductDto> pageResult, ModelMap modelMap){
        int currentPageNumber = pageResult.getNumber();
        Pageable prevPage = currentPageNumber > 0
                ? pageable.previousOrFirst()
                : null;
        Pageable nextPage = currentPageNumber < pageResult.getTotalPages() - 1
                ? pageable.next()
                : null;

        int totalPage = pageResult.getTotalPages() > 0 ? pageResult.getTotalPages() : 1;

        modelMap.addAttribute("products", pageResult.getContent());
        modelMap.addAttribute("totalPage", totalPage);
        modelMap.addAttribute("prevPage", prevPage);
        modelMap.addAttribute("nextPage", nextPage);
    }

    @GetMapping("/")
    public String home(ModelMap modelMap,
                       @PageableDefault(size = 6) Pageable pageable) {

        Page<ProductDto> pageResult = productService.getAllBy(pageable);

        pageSetting(pageable, pageResult, modelMap);

        return "index";
    }

    @GetMapping("/search")
    public String searchProducts(ModelMap modelMap,
                                 @Param("keyword") String keyword,
                                 @PageableDefault(size = 6) Pageable pageable){
        Page<ProductDto> pageResult = productService.findByModelNameContains(keyword, pageable);

        pageSetting(pageable, pageResult, modelMap);

        return "index";
    }
}

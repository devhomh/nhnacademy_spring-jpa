package com.nhnacademy.springjpa.controller;

import com.nhnacademy.springjpa.domain.ProductDto;
import com.nhnacademy.springjpa.service.CategoryService;
import com.nhnacademy.springjpa.service.ProductService;
import java.util.List;
import java.util.Objects;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    private final ProductService productService;

    private final CategoryService categoryService;

    public HomeController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
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

        List<String> categories = categoryService.findAll();

        modelMap.addAttribute("products", pageResult.getContent());
        modelMap.addAttribute("totalPage", totalPage);
        modelMap.addAttribute("prevPage", prevPage);
        modelMap.addAttribute("nextPage", nextPage);
        modelMap.addAttribute("categories", categories);
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
                                 @RequestParam("keyword") String keyword,
                                 @PageableDefault(size = 6) Pageable pageable){
        Page<ProductDto> pageResult = productService.findByModelNameContains(keyword, pageable);

        pageSetting(pageable, pageResult, modelMap);

        return "index";
    }

    @GetMapping("/sort")
    public String sortProductsByCategory(ModelMap modelMap,
                                         @RequestParam("category") String categoryName,
                                         @PageableDefault(size = 6) Pageable pageable){
        if(Objects.isNull(categoryName) || categoryName.isEmpty()){
            return "redirect:/";
        }

        Page<ProductDto> pageResult = productService.getProductByCategoryName(categoryName, pageable);

        pageSetting(pageable, pageResult, modelMap);

        modelMap.addAttribute("selected", categoryName);

        return "index";

    }

}

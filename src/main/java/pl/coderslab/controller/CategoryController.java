package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.repository.CategoryRepository;

@Controller
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {
    private static CategoryRepository categoryRepository;



}

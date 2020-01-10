package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Category;
import pl.coderslab.repository.CategoryRepository;

@Controller
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    @GetMapping("/list")
    public String getList(Model model){
        model.addAttribute("category", categoryRepository.getAll());
        return "category/list";
    }

    @GetMapping("/form")
    public String getForm(Model model){
        model.addAttribute("category", new Category());
        return "category/form";
    }

    @PostMapping
    public String saveCategory(@ModelAttribute Category category){
        categoryRepository.create(category);
        return "redirect:/category/list";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable long id, Model model){
        model.addAttribute("categoryId",id);
        return "category/delete";
    }

    @GetMapping("delete-action/{id}")
    public String deleteAction(@PathVariable long id, @RequestParam("action") boolean action){
        if(action){
            categoryRepository.delete(categoryRepository.getById(id));
        }
        return "redirect:/category/list";
    }


}

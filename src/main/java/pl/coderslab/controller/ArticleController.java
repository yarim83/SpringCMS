package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Category;
import pl.coderslab.repository.ArticleRepository;
import pl.coderslab.repository.AuthorRepository;
import pl.coderslab.repository.CategoryRepository;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleController {

    private final ArticleRepository articleRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;

    @GetMapping("/list")
    public String getList(Model model){
        model.addAttribute("article", articleRepository.getAll());
        return "article/list";
    }


    @GetMapping("/form")
    public String getForm(Model model){
        model.addAttribute("article", new Article());
        return "article/form";
    }

    @PostMapping
    public String saveArticle(@ModelAttribute Article article){
        articleRepository.create(article);
        return "redirect:/article/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id, Model model){
        model.addAttribute("articleId",id);
        return "article/delete";
    }

    @GetMapping("/delete-action/{id}")
    public String deleteAction(@PathVariable long id, @RequestParam("action") boolean action){
        if(action){
            articleRepository.delete(articleRepository.getById(id));
        }
        return "redirect:/article/list";
    }

    @GetMapping("edit/{id}")
    public String editArticle(@PathVariable long id, Model model){
        model.addAttribute("article", articleRepository.getById(id));
        return "article/edit";
    }

    @PostMapping("/edit")
    public String updateArticle(@ModelAttribute Article article, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "article/edit";
        }
        articleRepository.update(article);
        return "redirect:/article/list";
    }

    @ModelAttribute("authors")
    public List<Author> authorList() {
        return authorRepository.getAll();
    }

    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryRepository.getAll();
    }
}

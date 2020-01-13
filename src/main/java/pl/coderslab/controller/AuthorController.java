package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Author;
import pl.coderslab.repository.AuthorRepository;

@Controller
@RequiredArgsConstructor
@RequestMapping("/author")
public class AuthorController {

    private final AuthorRepository authorRepository;

    @GetMapping("/list")
    public String getList(Model model){
        model.addAttribute("author", authorRepository.getAll());
        return "author/list";
    }

    @GetMapping("/form")
    public String getForm(Model model){
        model.addAttribute("author", new Author());
        return "author/form";
    }

    @PostMapping
    public String saveAuthor(@ModelAttribute Author author, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "author/form";
        }
        authorRepository.create(author);
        return "redirect:/author/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id, Model model){
        model.addAttribute("authorId",id);
        return "author/delete";
    }

    @GetMapping("/delete-action/{id}")
    public String deleteAction(@PathVariable long id, @RequestParam("action") boolean action){
        if(action){
            authorRepository.delete(authorRepository.getById(id));
        }
        return "redirect:/author/list";
    }

    @GetMapping("edit/{id}")
    public String editAuthor(@PathVariable long id, Model model){
        model.addAttribute("author", authorRepository.getById(id));
        return "author/edit";
    }

    @PostMapping("/edit")
    public String updateAuthor(@ModelAttribute Author author, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "author/edit";
        }
        authorRepository.update(author);
        return "redirect:/author/list";
    }
}

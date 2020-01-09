package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Article;
import pl.coderslab.repository.ArticleRepository;

import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomePageController {
    private final ArticleRepository articleRepository;

    @GetMapping
    public String index(Model model){
        List<Article> articles = articleRepository.getFiveArticle();
        for (Article article: articles) {
            String content = article.getContent();
            article.setContent(content.substring(0,content.length() <= 200 ? content.length() : 200));
        }
        model.addAttribute("articles", articles);
        return "index";
    }






}

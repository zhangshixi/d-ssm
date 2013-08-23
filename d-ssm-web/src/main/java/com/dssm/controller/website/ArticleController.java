package com.dssm.controller.website;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dssm.controller.BaseController;
import com.dssm.domain.website.Article;
import com.dssm.service.website.ArticleService;

@Controller
public class ArticleController extends BaseController {

    @Autowired
    private ArticleService articleService;
    
    @RequestMapping(value="/article", method=RequestMethod.GET)
    public String showArticleList() {
        return null;
    }
    
	@RequestMapping(value="/article/create", method=RequestMethod.GET)
	public String toNewArticle() {
		return null;
	}
	
	@RequestMapping(value="/article", method=RequestMethod.POST)
	public String newArticle(Article article) {
	    articleService.addArticle(article);
	    return null;
	}
	
	@RequestMapping(value="/article/{id}", method=RequestMethod.GET)
	public String showArticle(@PathVariable int id) {
	    return null;
	}

	@RequestMapping(value="/article/{id}", method=RequestMethod.PUT)
	public String editArticle(@PathVariable int id, Article article) {
		return null;
	}
	
	@RequestMapping(value="/article/{id}", method=RequestMethod.DELETE)
	public String removeArticle(@PathVariable int id) {
		articleService.removeArticleById(id);
		return null;
	}
	
}

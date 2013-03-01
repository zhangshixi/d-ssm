package com.mjee.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mjee.app.domain.Article;

@Controller
public class ArticleController extends AbstractController {

    @RequestMapping(value="/article", method=RequestMethod.GET)
    public String showArticleList() {
        return null;
    }
    
	@RequestMapping(value="/article/new", method=RequestMethod.GET)
	public String toNewArticle() {
		return null;
	}
	
	@RequestMapping(value="/article", method=RequestMethod.POST)
	public String newArticle(Article article) {
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
		return null;
	}
	
}

package com.mjee.app.service.support;

import org.springframework.beans.factory.annotation.Autowired;

import com.mjee.app.domain.Article;
import com.mjee.app.domain.ArticleCategory;
import com.mjee.app.domain.ArticleComment;
import com.mjee.app.exception.NotExistedException;
import com.mjee.app.mapper.ArticleCategoryMapper;
import com.mjee.app.mapper.ArticleCommentMapper;
import com.mjee.app.mapper.ArticleMapper;
import com.mjee.app.service.AbstractService;
import com.mjee.app.service.ArticleService;
import com.mtoolkit.page.Page;
import com.mtoolkit.util.DateUtil;

public class ArticleServiceSupport extends AbstractService implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private ArticleCommentMapper articleCommentMapper;
    @Autowired
    private ArticleCategoryMapper articleCategoryMapper;
    
    @Override
    public int addArticle(Article article) {
        article.setCreateTime(DateUtil.getCurrentTime());
        return articleMapper.insert(article);
    }

    @Override
    public int removeArticle(int articleId) {
        Article targetArticle = doFindArticleById(articleId);
        if (targetArticle == null) {
            throw new NotExistedException();
        }
        
        articleCommentMapper.deleteByArticle(articleId);
        return articleMapper.delete(articleId);
    }

    @Override
    public int editArticle(Article article) {
        article.setUpdateTime(DateUtil.getCurrentTime());
        return articleMapper.updateSelective(article);
    }

    @Override
    public Article findArticleById(int articleId) {
        return doFindArticleById(articleId);
    }

    @Override
    public Page<Article> queryArticlesByPage(Page<Article> page) {
        return null;
    }

    @Override
    public Page<Article> queryArticlesByNew(Page<Article> page) {
        return null;
    }

    @Override
    public Page<Article> queryArticlesByVisit(Page<Article> page) {
        return null;
    }

    @Override
    public Page<Article> queryArticlesByComment(Page<Article> page) {
        return null;
    }

    @Override
    public Page<Article> queryArticlesByCategory(int categoryId, Page<Article> page) {
        return null;
    }

    @Override
    public int addArticleCategory(ArticleCategory articleCategory) {
        return articleCategoryMapper.insert(articleCategory);
    }

    @Override
    public int removeArticleCategory(int categoryId) {
        // TODO:
        articleCategoryMapper.delete(categoryId);
        return 0;
    }

    @Override
    public int editArticleCategory(ArticleCategory articleCategory) {
        return articleCategoryMapper.update(articleCategory);
    }

    @Override
    public ArticleCategory findArticleCategoryById(int categoryId) {
        return articleCategoryMapper.selectById(categoryId);
    }

    @Override
    public Page<ArticleCategory> queryArticleCategoriesByPage(Page<ArticleCategory> page) {
        return null;
    }

    @Override
    public int addArticleComment(ArticleComment articleComment) {
        articleComment.setIp(null);
        return articleCommentMapper.insert(articleComment);
    }

    @Override
    public int removeArticleComment(int commentId) {
        return articleCategoryMapper.delete(commentId);
    }

    @Override
    public Page<ArticleComment> queryArticleCommentsByPage(int articleId, Page<ArticleComment> page) {
        return null;
    }

    
    // ---- private methods
    private Article doFindArticleById(int articleId) {
        if (articleId <= 0) {
            return null;
        } else {
            return articleMapper.selectById(articleId);
        }
    }
    
}

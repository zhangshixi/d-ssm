package com.mjee.service.website.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjee.domain.website.Article;
import com.mjee.domain.website.ArticleCategory;
import com.mjee.domain.website.ArticleComment;
import com.mjee.exception.NotExistedException;
import com.mjee.mapper.website.ArticleCategoryMapper;
import com.mjee.mapper.website.ArticleCommentMapper;
import com.mjee.mapper.website.ArticleMapper;
import com.mjee.service.AbstractService;
import com.mjee.service.website.ArticleService;
import com.mtoolkit.page.Page;
import com.mtoolkit.util.DateUtil;

@Service
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
    public int removeArticleById(int articleId) {
        Article targetArticle = doFindArticleById(articleId);
        if (targetArticle == null) {
            throw new NotExistedException();
        }
        
        articleCommentMapper.deleteByArticle(articleId);
        return articleMapper.deleteById(articleId);
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
    public int removeArticleCategoryById(int categoryId) {
        // TODO:
        articleCategoryMapper.deleteById(categoryId);
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
    public int removeArticleCommentById(int commentId) {
        return articleCategoryMapper.deleteById(commentId);
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

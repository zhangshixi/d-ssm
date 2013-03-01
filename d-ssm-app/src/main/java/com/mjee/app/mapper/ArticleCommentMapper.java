package com.mjee.app.mapper;

import com.mjee.app.domain.ArticleComment;

public interface ArticleCommentMapper extends BaseMapper<ArticleComment> {
	
    public int deleteByArticle(int articleId);
    
}
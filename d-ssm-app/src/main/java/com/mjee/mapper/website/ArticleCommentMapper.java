package com.mjee.mapper.website;

import com.mjee.domain.website.ArticleComment;
import com.mjee.mapper.BaseMapper;

public interface ArticleCommentMapper extends BaseMapper<ArticleComment> {
	
    public int deleteByArticle(int articleId);
    
}
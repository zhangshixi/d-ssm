package com.dssm.mapper.website;

import com.dssm.domain.website.ArticleComment;
import com.dssm.mapper.BaseMapper;

public interface ArticleCommentMapper extends BaseMapper<ArticleComment> {
	
    public int deleteByArticle(Long articleId);
    
}
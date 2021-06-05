package com.root2z.service.impl;

import com.root2z.dao.ArticleMapper;
import com.root2z.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleMapper articleMapper;

    @Autowired
    public ArticleServiceImpl(ArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }

    @Override
    public int countArticle() {
        return articleMapper.totalCount();
    }
}

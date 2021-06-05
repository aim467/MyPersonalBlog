package com.root2z.service.impl;

import com.root2z.dao.TagMapper;
import com.root2z.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements TagService {

    private final TagMapper tagMapper;

    @Autowired
    public TagServiceImpl(TagMapper tagMapper) {
        this.tagMapper = tagMapper;
    }

    @Override
    public int countTag() {
        return tagMapper.totalCount();
    }
}

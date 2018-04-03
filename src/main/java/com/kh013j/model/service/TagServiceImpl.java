package com.kh013j.model.service;

import com.kh013j.model.domain.Tag;
import com.kh013j.model.repository.TagRepository;
import com.kh013j.model.service.interfaces.TagService;

import javax.annotation.Resource;

public class TagServiceImpl implements TagService{

    @Resource
    private TagRepository tagRepository;

    @Override
    public Tag getByTitle(String title) {
        return tagRepository.findByTitle(title);
    }
}

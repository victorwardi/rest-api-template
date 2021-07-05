package com.vwardi.restapitemplate.service;

import java.util.List;

import com.vwardi.restapitemplate.exception.ResourceNotFoundException;
import com.vwardi.restapitemplate.model.Basic;
import com.vwardi.restapitemplate.repository.BasicRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class BasicService {

    private final BasicRepository basicRepository;

    public BasicService(BasicRepository basicRepository) {
        this.basicRepository = basicRepository;
    }

    public Basic save(Basic newBasic){

        Assert.notNull(newBasic, "Basic cannot be null");

        return basicRepository.save(newBasic);
    }

    public Basic getBasicById(Long id){

        Assert.notNull(id, "Id cannot be null");

        return basicRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Basic", id.toString()));
    }

    public List<Basic> getAllBasics(){
        return basicRepository.findAll();
    }
}

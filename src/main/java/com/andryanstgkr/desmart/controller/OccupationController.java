package com.andryanstgkr.desmart.controller;

import com.andryanstgkr.desmart.base.BaseController;
import com.andryanstgkr.desmart.model.Occupation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin()
@RequestMapping("/occupation")
public class OccupationController extends BaseController<Occupation>{
    @Autowired
    Occupation occupation;
    public OccupationController(Occupation clazz) {
        super(clazz);
        this.occupation = clazz;
    }
}

package com.andryanstgkr.desmart.controller;

import com.andryanstgkr.desmart.base.BaseController;
import com.andryanstgkr.desmart.model.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parent")
public class ParentController extends BaseController<Parent>{

    @Autowired
    Parent parent;
    public ParentController(Parent clazz) {
        super(clazz);
        parent = clazz;
    }
}

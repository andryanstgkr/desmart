package com.andryanstgkr.desmart.controller;

import com.andryanstgkr.desmart.base.BaseController;
import com.andryanstgkr.desmart.model.SubVillage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subvillage")
public class SubVillageController extends BaseController<SubVillage> {

    @Autowired
    SubVillage subVillage;

    public SubVillageController(SubVillage clazz) {
        super(clazz);
        subVillage = clazz;
    }
}

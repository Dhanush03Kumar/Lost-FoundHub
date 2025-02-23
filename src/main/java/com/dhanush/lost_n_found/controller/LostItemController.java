package com.dhanush.lost_n_found.controller;

import com.dhanush.lost_n_found.model.LostItem;
import com.dhanush.lost_n_found.service.LostItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/lost-items")
public class LostItemController {
    @Autowired
    private LostItemService lostItemService;

    @PostMapping
    public LostItem addItem(@RequestBody LostItem lostItem) {
        return lostItemService.addItem(lostItem);
    }
}

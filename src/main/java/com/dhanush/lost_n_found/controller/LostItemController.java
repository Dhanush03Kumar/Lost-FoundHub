package com.dhanush.lost_n_found.controller;

import com.dhanush.lost_n_found.model.LostItem;
import com.dhanush.lost_n_found.service.LostItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/lost-items")
public class LostItemController {
    @Autowired
    private LostItemService lostItemService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addItem(@RequestBody LostItem lostItem) {
        lostItemService.addItem(lostItem);
    }

    @GetMapping
    public List<LostItem> getItem(){
        return lostItemService.getItem();
    }

    @GetMapping("/search")
    public LostItem getItemById(@RequestParam(required = false) Long id){
        return lostItemService.getItemById(id);
    }

    @GetMapping("/found")
    public List<LostItem> getFoundItems(){
        return lostItemService.getFoundItems();
    }

    @PutMapping
    public void updateItem(@RequestBody LostItem lostItem){
        lostItemService.updateItem(lostItem);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteItem(@RequestParam Long id){
        lostItemService.deleteItem(id);
    }
}

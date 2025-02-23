package com.dhanush.lost_n_found.service;

import com.dhanush.lost_n_found.model.LostItem;
import com.dhanush.lost_n_found.repository.LostItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LostItemService {
    @Autowired
    private LostItemRepository lostItemRepository;

    public LostItem addItem(LostItem lostItem) {
        return lostItemRepository.save(lostItem);
    }

}

package com.dhanush.lost_n_found.service;

import com.dhanush.lost_n_found.model.LostItem;
import com.dhanush.lost_n_found.repository.LostItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LostItemService {
    @Autowired
    private LostItemRepository lostItemRepository;

    public void addItem(LostItem lostItem) {
        try {
            lostItemRepository.save(lostItem);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Item not added. Please make sure all fields are present");
        }
    }

    public List<LostItem> getItem(){
        return lostItemRepository.findAll();
    }

    public LostItem getItemById(Long id) {
        return lostItemRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found"));
    }

    public List<LostItem> getFoundItems() {
        return lostItemRepository.findAll().stream().filter(lostItem -> lostItem.isFound()).toList();
    }

    public LostItem updateItem(LostItem lostItem) {
        Optional<LostItem> existingLostItem = lostItemRepository.findById(lostItem.getId());

        if(existingLostItem.isPresent()){
            return lostItemRepository.save(lostItem);
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Item not found, update failed. Please make sure lost item id is present");
        }
    }

    public void deleteItem(Long id) {
        lostItemRepository.deleteById(id);
    }
}

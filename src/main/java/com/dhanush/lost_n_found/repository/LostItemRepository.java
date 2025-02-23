package com.dhanush.lost_n_found.repository;

import com.dhanush.lost_n_found.model.LostItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LostItemRepository extends JpaRepository<LostItem,Long> {

}

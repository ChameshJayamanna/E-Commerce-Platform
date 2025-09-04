package com.web.inventory.repo;


import com.web.inventory.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepo extends JpaRepository<Inventory, Integer> {
    @Query(value = "SELECT * FROM inventory WHERE item_id = ?1", nativeQuery = true)
        // even though in model item id is named as itemId when it goes to database its saved as item_id that's the generic way
    Inventory getItemById(Integer itemId);
}

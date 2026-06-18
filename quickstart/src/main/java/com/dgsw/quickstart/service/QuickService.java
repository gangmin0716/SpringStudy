package com.dgsw.quickstart.service;

import com.dgsw.quickstart.dto.ItemDTO;
import com.dgsw.quickstart.entity.ItemEntity;
import com.dgsw.quickstart.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class QuickService {
    @Autowired
    ItemRepository itemRepository;

    public boolean registerItem(ItemDTO itemDTO) {
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setId(itemDTO.getId());
        itemEntity.setName(itemDTO.getName());
        ItemEntity saved = itemRepository.save(itemEntity);
        return saved != null;
    }
}

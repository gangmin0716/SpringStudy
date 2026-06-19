package com.dgsw.quickstart.service;

import com.dgsw.quickstart.dto.ItemDTO;
import com.dgsw.quickstart.entity.ItemEntity;
import com.dgsw.quickstart.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public ItemDTO getItemById(String id) {
        Optional<ItemEntity> optional = itemRepository.findById(id);
        if (optional.isPresent()) {
            ItemEntity itemEntity = optional.get();
            ItemDTO itemDTO = new ItemDTO();
            itemDTO.setId(itemEntity.getId());
            itemDTO.setName(itemEntity.getName());
            return itemDTO;
        }
        return null;
    }

    public List<ItemDTO> getAllItems() {
        return itemRepository.findAll().stream().map(entity -> {
            ItemDTO dto = new ItemDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            return dto;
        }).collect(Collectors.toList());
    }

    public boolean updateItem(ItemDTO itemDTO) {
        Optional<ItemEntity> optional = itemRepository.findById(itemDTO.getId());
        if (optional.isPresent()) {
            ItemEntity itemEntity = optional.get();
            itemEntity.setName(itemDTO.getName());
            itemRepository.save(itemEntity);
            return true;
        }
        return false;
    }

    public boolean deleteItem(String id) {
        if (itemRepository.existsById(id)) {
            itemRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

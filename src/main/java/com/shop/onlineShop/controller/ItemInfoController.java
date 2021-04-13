package com.shop.onlineShop.controller;

import com.shop.onlineShop.entity.ItemInfo;
import com.shop.onlineShop.service.ItemInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ItemInfoController {

    private final ItemInfoService itemInfoService;

    @Autowired
    public ItemInfoController(ItemInfoService itemInfoService){
        this.itemInfoService = itemInfoService;
    }
    @PostMapping("/itemInfo")
    public ResponseEntity<?> create(@RequestBody ItemInfo itemInfo){
        itemInfoService.create(itemInfo);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/itemInfo")
    public ResponseEntity<List<ItemInfo>> findALL(){
        final List<ItemInfo> itemInfoList = itemInfoService.findAll();
        return itemInfoList != null && !itemInfoList.isEmpty()
                ? new ResponseEntity<>(itemInfoList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/itemInfo/{id}")
    public ResponseEntity<Optional<ItemInfo>> find(@PathVariable(name = "id")Long id){
        final Optional<ItemInfo> itemInfo = itemInfoService.find(id);
        return itemInfo!=null
                ? new ResponseEntity<>(itemInfo, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/itemInfo/{id}")
    public ResponseEntity<?> updateItemInfo(@PathVariable(name = "id")Long id, @RequestBody ItemInfo itemInfoUpdate){
        return itemInfoService.find(id).map(itemInfo -> {
            itemInfo.setParentItem(itemInfoUpdate.getParentItem());
            itemInfo.setAmount(itemInfoUpdate.getAmount());
            itemInfo.setColour(itemInfoUpdate.getColour());
            itemInfo.setPrice(itemInfoUpdate.getPrice());
            itemInfoService.update(itemInfo);
            return new ResponseEntity<>(itemInfo, HttpStatus.OK);
        }).orElseThrow(() -> new IllegalArgumentException());
    }


}

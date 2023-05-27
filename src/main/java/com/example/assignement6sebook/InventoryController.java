package com.example.assignement6sebook;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class InventoryController
{
    prvate inventory;

    public InventoryController()
    {
        inventory = new Inventory();
    }
}

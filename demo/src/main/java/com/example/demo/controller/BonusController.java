package com.example.demo.controller;

import com.example.demo.Model.Bonus;
import com.example.demo.Service.BonusService;
import com.example.demo.repository.BonusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/bonus")
public class BonusController {
    @Autowired
    BonusService bonusService;
    @GetMapping("/allbonus")
    public List<Bonus> getBonus()
    {
        return bonusService.getBonus();
    }
    @PostMapping("/addbonus")
    public void addBonus(@RequestBody Bonus bonus)
    {
        bonusService.addNewBonus(bonus);
    }
    @GetMapping("/increment")
    public ResponseEntity<String> incrementBonus() {
        bonusService.incrementBonus();
        return ResponseEntity.ok("Bonus incremented and student notified.");
    }

}

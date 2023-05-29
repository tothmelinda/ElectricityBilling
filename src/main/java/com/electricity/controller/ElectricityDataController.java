package com.electricity.controller;

import com.electricity.dto.ElectricityDataDTO;
import com.electricity.service.ElectricityDataService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/electricity-data")
public class ElectricityDataController {

    private ElectricityDataService electricityDataService;

    @GetMapping
    public ResponseEntity<List<ElectricityDataDTO>> findAll() {
        return ResponseEntity.ok(electricityDataService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ElectricityDataDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(electricityDataService.getById(id));
    }

    @PostMapping
    public ResponseEntity<ElectricityDataDTO> add(@RequestBody ElectricityDataDTO electricityDataDTO) {
        return ResponseEntity.ok(electricityDataService.add(electricityDataDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ElectricityDataDTO> update(@PathVariable Long id, @RequestBody ElectricityDataDTO electricityDataDTO) {
        return ResponseEntity.ok(electricityDataService.update(id, electricityDataDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        electricityDataService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}

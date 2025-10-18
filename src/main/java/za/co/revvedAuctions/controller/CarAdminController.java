package za.co.revvedAuctions.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.revvedAuctions.domain.CarAdmin;
import za.co.revvedAuctions.service.implementation.CarAdminService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/caradmin")
public class CarAdminController {

    @Autowired
    private CarAdminService carAdminService;

    @PostMapping("/create")
    public ResponseEntity<CarAdmin> create(@RequestBody CarAdmin carAdmin) {
        return ResponseEntity.ok(carAdminService.create(carAdmin));
    }

//    @GetMapping("/read/{id}")
//    public ResponseEntity<CarAdmin> read(@PathVariable UUID id) {
//        return ResponseEntity.ok(carAdminService.read(id));
//    }

    @PutMapping("/update")
    public ResponseEntity<CarAdmin> update(@RequestBody CarAdmin carAdmin) {
        return ResponseEntity.ok(carAdminService.update(carAdmin));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        carAdminService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getall")
    public ResponseEntity<List<CarAdmin>> getAll() {
        return ResponseEntity.ok(carAdminService.getAll());
    }
}

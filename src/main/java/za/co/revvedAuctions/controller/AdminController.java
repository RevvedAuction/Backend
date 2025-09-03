package za.co.revvedAuctions.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.revvedAuctions.domain.Admin;
import za.co.revvedAuctions.service.implementation.AdminService;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService){
        this.adminService = adminService;
    }

    @PostMapping("/create")
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
        Admin saved = adminService.create(admin);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/read/{adminId}")
    public Admin readId(@PathVariable String adminId){
        return adminService.read(UUID.fromString(adminId));
    }

    @GetMapping("/findAdminNumber/{adminNumber}")
    public Admin readAdminNumber(@PathVariable int adminNumber){
        return adminService.findAdmin(adminNumber);
    }

    @PutMapping("/update")
    public Admin updateAdmin(@RequestBody Admin admin){
        return adminService.update(admin);
    }

    @DeleteMapping("/delete/{adminNumber}")
    public Admin deleteAdmin(@PathVariable int adminNumber){ return adminService.delete(adminNumber);}

    @GetMapping("/getall")
    public List<Admin> getAllAdmins(){ return adminService.getAll(); }

}

package com.letsdo.letsgot.controllers;


import com.letsdo.letsgot.dto.DepartmentDto;
import com.letsdo.letsgot.entities.DepartmentEntities;
import com.letsdo.letsgot.repository.DepartmentRepository;
import com.letsdo.letsgot.services.DepartmentServices;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping(path = "/departments")

public class DepartmentController {


private final DepartmentServices departmentServices;

    public DepartmentController(DepartmentServices departmentServices) {
        this.departmentServices = departmentServices;
    }

    @GetMapping(path= "/{departmentId}")
    public ResponseEntity <DepartmentDto> getDepartmentById(@PathVariable (name = "departmentId") Long id){
    Optional<  DepartmentDto> departmentDto =   departmentServices.getDepartmentById(id);

     return departmentDto.map(departmentDto1 -> ResponseEntity.ok(departmentDto1))
             .orElseThrow(()-> new NoSuchElementException("employee not found"));
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartment(@RequestParam(required = false) Long id,
                                                     @RequestParam(required = false)String title)

    {
        return ResponseEntity.ok(departmentServices.getAllDepartment());
    }



    @PostMapping
    public ResponseEntity<List<DepartmentDto>> createNewDepartment(@RequestBody @Valid List<DepartmentDto >inputDepartment){

      List<DepartmentDto> saveAllDepartment=  departmentServices.createNewDepartment(inputDepartment);

       return new ResponseEntity<>(saveAllDepartment, HttpStatus.CREATED);
}

@PutMapping("/{id}")
public ResponseEntity<DepartmentDto >updateDepartmentById(   @PathVariable Long id,
                                              @RequestBody DepartmentDto  departmentDto){

    return ResponseEntity.ok(departmentServices.updateDepartmentById(id,departmentDto));

}

    @PatchMapping("/{id}")
    public ResponseEntity< DepartmentDto> updateDepartmentPartiallyById(   @PathVariable Long id,
                                                 @RequestBody DepartmentDto  departmentDto){

        DepartmentDto departmentDto1 = departmentServices.updateDepartmentPartiallyById(id,departmentDto);

        if(departmentDto1==null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(departmentDto1);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteDepartmentById(   @PathVariable Long id){
    Boolean gotDeleted = departmentServices.deleteDepartmentById(id);
     if(gotDeleted) return ResponseEntity.ok(true);

     return ResponseEntity.notFound().build();




    }

}

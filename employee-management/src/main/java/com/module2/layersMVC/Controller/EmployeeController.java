package com.module2.layersMVC.Controller;


import com.module2.layersMVC.dto.EmployeeDto;

import com.module2.layersMVC.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping (path = "/employees")
public class EmployeeController {


  public final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping(path= "/{employeeId}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable(name ="employeeId" ) Long id){
     Optional< EmployeeDto> employeeDto= employeeService.getEmployeeById(id);
     // if(employeeDto== null) return ResponseEntity.notFound().build();
  return employeeDto.map
          (employeeDto1 -> ResponseEntity.ok(employeeDto1))
          .orElseThrow(()-> new RuntimeException("employee not found with id :"+ id));

    }


    @GetMapping

   public ResponseEntity< List<EmployeeDto>> getAllEmployeed(@RequestParam (required = false)Integer age,
                                               @RequestParam (required = false)String name){
        return ResponseEntity.ok(employeeService.getAlltheEmployee());
    }

    @PostMapping


    public  ResponseEntity<EmployeeDto> createNewEmployee(@RequestBody @Valid EmployeeDto inputEmployee){
        EmployeeDto savedEmployee = employeeService.createNewEmployee(inputEmployee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{employeeId}")
   public ResponseEntity<EmployeeDto> updateEmployeeById(@RequestBody EmployeeDto employeeDto,@PathVariable Long employeeId){

        return ResponseEntity.ok(employeeService.updateEmployeeById(employeeId,employeeDto));
    }


    @DeleteMapping(path = "/{employeeId}")
    public ResponseEntity <Boolean> deleteEmployeeById(@PathVariable Long employeeId){
        boolean gotDeleted= employeeService.deleteEmployeeById(employeeId);
        if(gotDeleted) return  ResponseEntity.ok(true);
        return  ResponseEntity.notFound().build();
    }


    @PatchMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDto>  updatePartialEmployeeTd(@RequestBody Map<String, Object> updates,
                                                                 @PathVariable Long employeeId) {
        EmployeeDto  employeeDTO = employeeService. updatePartialEmployeeTd(employeeId, updates);
        if (employeeDTO == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(employeeDTO);
    }
}

package com.module2.layersMVC.service;


import com.module2.layersMVC.dto.EmployeeDto;
import com.module2.layersMVC.entity.EmployeeEntity;
import com.module2.layersMVC.exceptions.ResourceNotFoundException;
import com.module2.layersMVC.repository.EmployeeRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

      private final ModelMapper modelMapper;
    private final EmployeeRepo employeeRepo;

    public EmployeeService(ModelMapper modelMapper, EmployeeRepo employeeRepo) {
        this.modelMapper = modelMapper;
        this.employeeRepo = employeeRepo;
    }

    public Optional<EmployeeDto> getEmployeeById(Long id) {

  return employeeRepo.findById(id).map
          (employeeEntity -> modelMapper.map(employeeEntity,EmployeeDto.class));
    }

    public List<EmployeeDto> getAlltheEmployee() {
        List<EmployeeEntity> employeeEntities= employeeRepo.findAll();

       return employeeEntities
               .stream()
               .map(employeeEntity -> modelMapper.map(employeeEntity,EmployeeDto.class))
               .collect(Collectors.toList());

    }

    public EmployeeDto createNewEmployee(EmployeeDto inputEmployee) {
       EmployeeEntity toSaveEntity = modelMapper.map(inputEmployee,EmployeeEntity.class);
       EmployeeEntity savedEmployeeEntity=employeeRepo.save(toSaveEntity);
       return modelMapper.map(savedEmployeeEntity,EmployeeDto.class);
    }

    public EmployeeDto updateEmployeeById(Long employeeId, EmployeeDto employeeDto) {
        boolean exists = isExistByEmployeeId(employeeId);
        if(!exists)throw new ResourceNotFoundException(" employee not found: "+ employeeId);
       EmployeeEntity employeeEntity = modelMapper.map(employeeDto,EmployeeEntity.class);
       employeeEntity.setId(employeeId);
       EmployeeEntity savedEmployeeEntity = employeeRepo.save(employeeEntity);
       return modelMapper.map(savedEmployeeEntity,EmployeeDto.class);
    }


    public boolean isExistsByEmployeeId(Long employeeId){
        return employeeRepo.existsById(employeeId);
    }
    public boolean deleteEmployeeById(Long employeeId) {

           boolean exists = isExistByEmployeeId(employeeId);
           if(!exists) throw new ResourceNotFoundException(" employee not found: "+ employeeId);
         employeeRepo.deleteById(employeeId);

        return true;
    }


public EmployeeDto updatePartialEmployeeTd(long employeeId, Map<String, Object> updates) {
    boolean exists = isExistByEmployeeId(employeeId);
    if (!exists) return null;

    EmployeeEntity employeeEntity = employeeRepo.findById(employeeId).get();

    updates.forEach((field, value) -> {
        Field fieldToBeUpdated = ReflectionUtils.findField(EmployeeEntity.class, field);
        fieldToBeUpdated.setAccessible(true);
        ReflectionUtils.setField(fieldToBeUpdated, employeeEntity, value);
    });

    return modelMapper.map(employeeRepo.save(employeeEntity), EmployeeDto.class);
}


    public boolean isExistByEmployeeId(Long employeeId){
        return employeeRepo.existsById(employeeId);
    }



}



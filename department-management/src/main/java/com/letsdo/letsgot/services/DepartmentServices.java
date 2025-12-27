package com.letsdo.letsgot.services;


import com.letsdo.letsgot.dto.DepartmentDto;
import com.letsdo.letsgot.entities.DepartmentEntities;
import com.letsdo.letsgot.repository.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServices {

    private final DepartmentRepository departmentRepository;
    public final ModelMapper modelMapper;

    public DepartmentServices(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }

    public Optional<DepartmentDto> getDepartmentById(Long id) {
        Optional<DepartmentEntities >departmentEntities = departmentRepository.findById(id);
        return departmentEntities.map(departmentEntities1 -> modelMapper.map(departmentEntities1,DepartmentDto.class));
    }

    public List<DepartmentDto> getAllDepartment() {
        List<DepartmentEntities> departmentEntities = departmentRepository.findAll();
        return departmentEntities.stream()
                .map(departmentEntity -> modelMapper.map(departmentEntity,DepartmentDto.class))
                .toList();
    }

    public List<DepartmentDto> createNewDepartment(List<DepartmentDto> inputDepartment) {
        List<DepartmentEntities> entities = inputDepartment.stream()
                .map(dto -> modelMapper.map(dto,DepartmentEntities.class)).toList();

        List<DepartmentEntities> saveEntities = departmentRepository.saveAll(entities);
        return saveEntities.stream()
                .map(departmentEntities -> modelMapper.map(departmentEntities,DepartmentDto.class)).toList();

    }

    public DepartmentDto updateDepartmentById(Long id, DepartmentDto departmentDto) {
        DepartmentEntities departmentEntities =departmentRepository.findById(id).orElseThrow();

        departmentEntities.setTitle(departmentDto.getTitle());
        departmentEntities.setIsActive(departmentDto.getIsActive());

        departmentRepository.save(departmentEntities);

        return modelMapper.map(departmentEntities,DepartmentDto.class);
    }

public DepartmentDto updateDepartmentPartiallyById(Long id, DepartmentDto departmentDto) {

    Optional<DepartmentEntities> optionalDepartment =
            departmentRepository.findById(id);

    if (optionalDepartment.isEmpty()) {
        return null; // controller will return 404
    }

    DepartmentEntities departmentEntities = optionalDepartment.get();

    if (departmentDto.getTitle() != null) {
        departmentEntities.setTitle(departmentDto.getTitle());
    }

    if (departmentDto.getIsActive() != null) {
        departmentEntities.setIsActive(departmentDto.getIsActive());
    }

    DepartmentEntities updatedDepartment =
            departmentRepository.save(departmentEntities);

    return modelMapper.map(updatedDepartment, DepartmentDto.class);
}


    public Boolean deleteDepartmentById(Long id) {
           boolean exists = departmentRepository.existsById(id);
           if(!exists) return false;
           departmentRepository.deleteById(id);
           return true;
    }






}

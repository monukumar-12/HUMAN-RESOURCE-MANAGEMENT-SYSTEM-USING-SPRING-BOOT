package com.module2.layersMVC.repository;

import com.module2.layersMVC.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository <EmployeeEntity,Long>{
//List<EmployeeEntity> findByName(String name);




}

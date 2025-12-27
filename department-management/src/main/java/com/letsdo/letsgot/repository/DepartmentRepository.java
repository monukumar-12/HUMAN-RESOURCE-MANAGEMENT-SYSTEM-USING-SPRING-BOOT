package com.letsdo.letsgot.repository;

import com.letsdo.letsgot.entities.DepartmentEntities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository <DepartmentEntities,Long> {
    DepartmentEntities deleteDepartmentEntitiesByDepartmentId(Long departmentId);
}

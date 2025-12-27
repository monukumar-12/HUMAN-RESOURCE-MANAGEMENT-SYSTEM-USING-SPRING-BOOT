package com.letsdo.letsgot.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentEntities {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long departmentId;
    private  String title;
    private  Boolean isActive;
    private LocalDateTime createdAt;

}

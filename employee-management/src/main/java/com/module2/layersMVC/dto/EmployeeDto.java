package com.module2.layersMVC.dto;

import com.module2.layersMVC.annotation.EmployeeRoleValidation;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private Long id;
    @NotBlank(message ="Required field in employee: name " )
    @Size(min = 8, max =15 ,message = "min 8 char max 25")
    private String name;

    @Email
    private String email;

@Max(value = 80,message = "age not more than 80")
@Min(value = 20 , message = "age cannot  be less than 18")
    private  Integer age;

//@Pattern(regexp = "^(ADMIN| USERS)$",message = "role of employee can be user or admin ")
    @EmployeeRoleValidation
private String role;
    private   LocalDate dateOfJoining;
    private Boolean isActive;




}

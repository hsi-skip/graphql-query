package com.hsi.graphql.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Users")
public class User {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@NotNull
	@NotBlank
    private String name;
	
	@NotNull
	@Min(10)
    private String phone;
	
	@NotNull
    private String email;
    private String address;  

}
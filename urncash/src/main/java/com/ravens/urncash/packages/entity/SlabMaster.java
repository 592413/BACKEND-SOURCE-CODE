package com.ravens.urncash.packages.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.Data;

@Data
@Entity
@Table(name="slab_master")
public class SlabMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long slabId;
}

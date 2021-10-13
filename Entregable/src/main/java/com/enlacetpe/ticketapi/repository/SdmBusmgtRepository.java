package com.enlacetpe.ticketapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enlacetpe.ticketapi.model.SdmBusmgtModel;

@Repository
public interface SdmBusmgtRepository extends JpaRepository<SdmBusmgtModel, Long>{
	
	public List<SdmBusmgtModel> findByHierParent(String cliente);
}

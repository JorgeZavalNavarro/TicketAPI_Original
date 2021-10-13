package com.enlacetpe.ticketapi.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import com.enlacetpe.ticketapi.model.SdmChgModel;




@Repository
public interface SdmChgRepository extends JpaRepository<SdmChgModel, Long>{
	
	public abstract List<SdmChgModel> findByChgRefNum(String rfc);
}

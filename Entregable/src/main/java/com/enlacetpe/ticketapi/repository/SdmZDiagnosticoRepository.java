package com.enlacetpe.ticketapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enlacetpe.ticketapi.model.SdmZDiagnosticoModel;


@Repository
public interface SdmZDiagnosticoRepository extends JpaRepository<SdmZDiagnosticoModel, Long>{
	
	public SdmZDiagnosticoModel findById(Integer id);
	public List<SdmZDiagnosticoModel> findDiagnostico();

}

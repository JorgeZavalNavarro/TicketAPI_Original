package com.enlacetpe.ticketapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enlacetpe.ticketapi.model.SdmZSolucionModel;



@Repository
public interface SdmZSolucionRepository extends JpaRepository<SdmZSolucionModel, Long>{
	
	public SdmZSolucionModel findById(Integer id);
	public List<SdmZSolucionModel> findByDiagnosticoIdAndDel(Integer id, Integer del);

}

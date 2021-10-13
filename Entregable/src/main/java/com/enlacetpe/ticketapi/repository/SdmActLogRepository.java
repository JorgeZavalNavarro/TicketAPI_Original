package com.enlacetpe.ticketapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.enlacetpe.ticketapi.model.SdmActLogModel;

@Repository
public interface SdmActLogRepository extends JpaRepository<SdmActLogModel, Long>{
	
	public List<SdmActLogModel> findByCallReqIdAndType(String refNum, String type);
	
	@Query(value="select a.call_req_id, a.description,a.system_time, b.sym \r\n" + 
			"from sdm_act_log a left join sdm_act_type b\r\n" + 
			"on a.type = b.code\r\n" + 
			"where call_req_id = :ticket\r\n" + 
			"order by system_time asc", nativeQuery=true)
	public abstract List<Object> getComentarios(@Param("ticket") String ticket);
	
	@Query(value="select a.call_req_id, a.description,a.system_time, b.sym \r\n" + 
			"from sdm_act_log a left join sdm_act_type b\r\n" + 
			"on a.type = b.code\r\n" + 
			"where call_req_id = :ticket\r\n" + 
			"and a.type = 'LOG'" +
			"order by system_time asc", nativeQuery=true)
	public abstract List<Object> getComentariosLog(@Param("ticket") String ticket);
	
}

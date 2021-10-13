package com.enlacetpe.ticketapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.enlacetpe.ticketapi.model.SdmCaOwnedResourceModel;
import com.enlacetpe.ticketapi.response.CAInformacionIpResponse;

@Repository
public interface SdmCaOwnedResourceRepository extends JpaRepository<SdmCaOwnedResourceModel, Long>{
	
		public List<SdmCaOwnedResourceModel> findByOwnResourceUuidInAndResourceClassNot(List<String> hijos,Integer resourceClass);
		public List<SdmCaOwnedResourceModel> findByOwnResourceUuidInAndResourceClass(List<String> hijos,Integer resourceClass);
		public List<SdmCaOwnedResourceModel> findByOwnResourceUuidIn(List<String> hijos);
		public List<SdmCaOwnedResourceModel> findByResourceNameIn(List<String> nombres);
		public SdmCaOwnedResourceModel findByOwnResourceUuid (String id);
		public SdmCaOwnedResourceModel findByResourceName (String resourceName);
		public SdmCaOwnedResourceModel findByResourceNameAndResourceFamilyAndInactive (String resourceName, Integer family, Integer inactive);
		public SdmCaOwnedResourceModel findByIpAddress(String ip);
		
		
		@Query(value="select a.resource_name, b.description, b.ref_num \r\n"
				+ "from sdm_ca_owned_resource a, sdm_call_req b \r\n"
				+ "where a.own_resource_uuid = b.affected_rc\r\nand a.resource_name in (?1)\r\n"
				+ "and b.description in(?2)\r\n"
				+ "and b.status = 'ZPRE'", nativeQuery=true)
		  public abstract List<Object> getTickets(List<String> paramList1, List<String> paramList2);
		
		
		@Query(value="select resource_name from sdm_ca_owned_resource where own_resource_uuid in\r\n" + 
				"(select hier_parent from sdm_busmgt where hier_child = "
				+ "(select affected_rc from sdm_call_req where ref_num = ?1  limit 1))", nativeQuery=true)
		  public abstract List<Object> getClinte(String refNum);
		
		
		@Query(value="select a.own_resource_uuid, b.org_name \r\n" + 
				"from datahub.sdm_ca_owned_resource a, datahub.sdm_ca_organization b\r\n" + 
				"where a.responsible_org_uuid = b.organization_uuid\r\n" + 
				"and ip_address = ?1  limit 1", nativeQuery=true)
		public abstract List<Object> getInformationIP(String ip);
		
		@Query(value="select own_resource_uuid,responsible_org_uuid from datahub.sdm_ca_owned_resource \r\n" + 
				"where resource_class = (select id from datahub.sdm_ca_resource_class where name = 'Numero de cuenta' and inactive = 0)\r\n" + 
				"and resource_name = ?1 ", nativeQuery=true)
		public abstract List<Object> getCuenta(String numeroCuenta);
		
		
}

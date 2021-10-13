package com.enlacetpe.ticketapi.cargasMasivas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.enlacetpe.ticketapi.modelCargas.CargasMasivasModel;

@Repository
public interface CargasMasivasRepository extends JpaRepository<CargasMasivasModel, Long> {

	@Query(value = "SELECT id_num_registro, columna_1, columna_2, columna_3, columna_4, \r\n"
			+ "	   columna_5, columna_6, columna_7, columna_8, columna_9, columna_10, \r\n"
			+ "       columna_11, columna_12, columna_13 \r\n" + "FROM portalcl.tb_cargas_masivas", nativeQuery = true)
	public abstract List<CargasMasivasModel> getRegistros();

}

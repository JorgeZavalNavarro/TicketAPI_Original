package com.enlacetpe.ticketapi.modelCargas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_cargas_masivas")
public class CargasMasivasModel {

	@Id
	@Column(name = "id_num_registro")
	private Long idNumRegistro;

	@Column(name = "columna_1")
	private String columna1;

	@Column(name = "columna_2")
	private String columna2;

	@Column(name = "columna_3")
	private String columna3;

	@Column(name = "columna_4")
	private String columna4;

	@Column(name = "columna_5")
	private String columna5;

	@Column(name = "columna_6")
	private String columna6;

	@Column(name = "columna_7")
	private String columna7;

	@Column(name = "columna_8")
	private String columna8;

	@Column(name = "columna_9")
	private String columna9;

	@Column(name = "columna_10")
	private String columna10;

	@Column(name = "columna_11")
	private String columna11;

	@Column(name = "columna_12")
	private String columna12;

	@Column(name = "columna_13")
	private String columna13;

	public Long getIdNumRegistro() {
		return idNumRegistro;
	}

	public void setIdNumRegistro(Long idNumRegistro) {
		this.idNumRegistro = idNumRegistro;
	}

	public String getColumna1() {
		return columna1;
	}

	public void setColumna1(String columna1) {
		this.columna1 = columna1;
	}

	public String getColumna2() {
		return columna2;
	}

	public void setColumna2(String columna2) {
		this.columna2 = columna2;
	}

	public String getColumna3() {
		return columna3;
	}

	public void setColumna3(String columna3) {
		this.columna3 = columna3;
	}

	public String getColumna4() {
		return columna4;
	}

	public void setColumna4(String columna4) {
		this.columna4 = columna4;
	}

	public String getColumna5() {
		return columna5;
	}

	public void setColumna5(String columna5) {
		this.columna5 = columna5;
	}

	public String getColumna6() {
		return columna6;
	}

	public void setColumna6(String columna6) {
		this.columna6 = columna6;
	}

	public String getColumna7() {
		return columna7;
	}

	public void setColumna7(String columna7) {
		this.columna7 = columna7;
	}

	public String getColumna8() {
		return columna8;
	}

	public void setColumna8(String columna8) {
		this.columna8 = columna8;
	}

	public String getColumna9() {
		return columna9;
	}

	public void setColumna9(String columna9) {
		this.columna9 = columna9;
	}

	public String getColumna10() {
		return columna10;
	}

	public void setColumna10(String columna10) {
		this.columna10 = columna10;
	}

	public String getColumna11() {
		return columna11;
	}

	public void setColumna11(String columna11) {
		this.columna11 = columna11;
	}

	public String getColumna12() {
		return columna12;
	}

	public void setColumna12(String columna12) {
		this.columna12 = columna12;
	}

	public String getColumna13() {
		return columna13;
	}

	public void setColumna13(String columna13) {
		this.columna13 = columna13;
	}

}

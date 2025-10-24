package com.imb2025.calificaciones.dto.response;

public class AsignacionDocenteResponseDto {
	private Long id;
	private Long docenteId;
	private Long materiaId;
	private Long comisionId;
	private Long periodoLectivoId;
	private Long version;
	private Boolean activa;

	public AsignacionDocenteResponseDto() {
	}

	public AsignacionDocenteResponseDto(Long id, Long docenteId, Long materiaId, Long comisionId,
			Long periodoLectivoId, Long version, Boolean activa) {
		this.id = id;
		this.docenteId = docenteId;
		this.materiaId = materiaId;
		this.comisionId = comisionId;
		this.periodoLectivoId = periodoLectivoId;
		this.version = version;
		this.activa = activa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDocenteId() {
		return docenteId;
	}

	public void setDocenteId(Long docenteId) {
		this.docenteId = docenteId;
	}

	public Long getMateriaId() {
		return materiaId;
	}

	public void setMateriaId(Long materiaId) {
		this.materiaId = materiaId;
	}

	public Long getComisionId() {
		return comisionId;
	}

	public void setComisionId(Long comisionId) {
		this.comisionId = comisionId;
	}

	public Long getPeriodoLectivoId() {
		return periodoLectivoId;
	}

	public void setPeriodoLectivoId(Long periodoLectivoId) {
		this.periodoLectivoId = periodoLectivoId;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Boolean getActiva() {
		return activa;
	}

	public void setActiva(Boolean activa) {
		this.activa = activa;
	}
}

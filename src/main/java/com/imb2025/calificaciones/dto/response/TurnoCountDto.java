package com.imb2025.calificaciones.dto.response;

public class TurnoCountDto {

	 private Long total;

	    public TurnoCountDto() {}

	    public TurnoCountDto(Long total) {
	        this.total = total;
	    }

	    public Long getTotal() {
	        return total;
	    }

	    public void setTotal(Long total) {
	        this.total = total;
	    }
}

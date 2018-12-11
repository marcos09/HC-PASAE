package ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto;

public class CantidadPorMesDTO {

	private Long cantidad;
	private String monthString;
	private int nroMes;
	
	public int getNroMes() {
		return nroMes;
	}


	public void setNroMes(int nroMes) {
		this.nroMes = nroMes;
	}


	public CantidadPorMesDTO(Long cantidad, int mes) {
		super();
		this.setCantidad(cantidad);	
		this.setNroMes(mes);
		
		switch (mes) {
        case 1:  monthString = "Enero";
                 break;
        case 2:  monthString = "Febrero";
                 break;
        case 3:  monthString = "Marzo";
                 break;
        case 4:  monthString = "Abril";
                 break;
        case 5:  monthString = "Mayo";
                 break;
        case 6:  monthString = "Junio";
                 break;
        case 7:  monthString = "Julio";
                 break;
        case 8:  monthString = "Agosto";
                 break;
        case 9:  monthString = "Septiembre";
                 break;
        case 10: monthString = "Octubre";
                 break;
        case 11: monthString = "Noviembre";
                 break;
        case 12: monthString = "Diciembre";
                 break;
        default: monthString = "Mes invalido";
                 break;
		}
	}
	
	public Long getCantidad() {
		return cantidad;
	}
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}


	public String getMonthString() {
		return monthString;
	}


	public void setMonthString(String monthString) {
		this.monthString = monthString;
	}
	
}

package cl.icap.fullstack.model.dto;



import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="valores")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class ValoresDto {
	

	private Integer tramo_id;
@Id
	private String origen;            
	private String destino;            
	private Integer costo;        
	private Integer cant_pasajeros;
	
	public ValoresDto() {
		
	}

	public Integer getTramo_id() {
		return tramo_id;
	}

	public void setTramo_id(Integer tramo_id) {
		this.tramo_id = tramo_id;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Integer getCosto() {
		return costo;
	}

	public void setCosto(Integer costo) {
		this.costo = costo;
	}

	public Integer getCant_pasajeros() {
		return cant_pasajeros;
	}

	public void setCant_pasajeros(Integer cant_pasajeros) {
		this.cant_pasajeros = cant_pasajeros;
	}
}



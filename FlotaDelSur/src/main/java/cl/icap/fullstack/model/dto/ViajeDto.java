package cl.icap.fullstack.model.dto;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="viaje")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class ViajeDto {
	@Id
	private Integer viaje_id;     
	private Integer cliente_id;            
	private Integer tipoviaje_id;            
	private Integer region_id;        
	private Integer comuna_id;
	private String vehiculo_ppu;                   
	private Integer conductor_id;       
	private Date viaje_fecha;       
	private Integer tipopago_id;
	private Integer costo;
	
	public ViajeDto() {
		
	}

	public Integer getViaje_id() {
		return viaje_id;
	}

	public void setViaje_id(Integer viaje_id) {
		this.viaje_id = viaje_id;
	}

	public Integer getCliente_id() {
		return cliente_id;
	}

	public void setCliente_id(Integer cliente_id) {
		this.cliente_id = cliente_id;
	}

	public Integer getTipoviaje_id() {
		return tipoviaje_id;
	}

	public void setTipoviaje_id(Integer tipoviaje_id) {
		this.tipoviaje_id = tipoviaje_id;
	}

	public Integer getRegion_id() {
		return region_id;
	}

	public void setRegion_id(Integer region_id) {
		this.region_id = region_id;
	}

	public Integer getComuna_id() {
		return comuna_id;
	}

	public void setComuna_id(Integer comuna_id) {
		this.comuna_id = comuna_id;
	}

	public String getVehiculo_ppu() {
		return vehiculo_ppu;
	}

	public void setVehiculo_ppu(String vehiculo_ppu) {
		this.vehiculo_ppu = vehiculo_ppu;
	}

	public Integer getConductor_id() {
		return conductor_id;
	}

	public void setConductor_id(Integer conductor_id) {
		this.conductor_id = conductor_id;
	}

	public Date getViaje_fecha() {
		return viaje_fecha;
	}

	public void setViaje_fecha(Date viaje_fecha) {
		this.viaje_fecha = viaje_fecha;
	}

	public Integer getTipopago_id() {
		return tipopago_id;
	}

	public void setTipopago_id(Integer tipopago_id) {
		this.tipopago_id = tipopago_id;
	}

	public Integer getCosto() {
		return costo;
	}

	public void setCosto(Integer costo) {
		this.costo = costo;
	}



	
}

package cl.icap.fullstack.model.dto;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;




@Entity
@Table(name="agenda_viajes")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Agenda_ViajesDto {
	
	@Id
	private Integer id_agenda;
	private String origen;
	private String destino;
	private String costo;
	private Integer cant_pasajeros;
	private Date fecha;
	private String correo;
	public Integer getId_agenda() {
		return id_agenda;
	}
	public void setId_agenda(Integer id_agenda) {
		this.id_agenda = id_agenda;
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
	public String getCosto() {
		return costo;
	}
	public void setCosto(String costo) {
		this.costo = costo;
	}
	public Integer getCant_pasajeros() {
		return cant_pasajeros;
	}
	public void setCant_pasajeros(Integer pasajeros) {
		this.cant_pasajeros = pasajeros;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	
	}
	
	



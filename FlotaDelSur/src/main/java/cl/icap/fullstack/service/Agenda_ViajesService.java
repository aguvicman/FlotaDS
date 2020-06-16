package cl.icap.fullstack.service;

import java.util.List;
import cl.icap.fullstack.model.dto.Agenda_ViajesDto;


public interface Agenda_ViajesService {	
	public Agenda_ViajesDto insert(Agenda_ViajesDto agenda_ViajesDto);
	public Agenda_ViajesDto get(int id_agenda);
	public Agenda_ViajesDto update(Agenda_ViajesDto agenda_ViajesDto);
	public void delete(Agenda_ViajesDto agenda_ViajesDto);
	public List <Agenda_ViajesDto> list();
	
	

}

package cl.icap.fullstack.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl.icap.fullstack.model.dto.Agenda_ViajesDto;
import cl.icap.fullstack.model.repository.Agenda_ViajesRepository;

@Service
public class Agenda_ViajesServiceImpl implements Agenda_ViajesService {
	
	@Autowired
	Agenda_ViajesRepository agenda_ViajesRepository;
	
	@Override
	public List<Agenda_ViajesDto> list() {
		return agenda_ViajesRepository.findAll();
	}

	@Override
	public Agenda_ViajesDto insert(Agenda_ViajesDto agenda_ViajesDto) {
		return agenda_ViajesRepository.save(agenda_ViajesDto);
	}

	@Override
	public Agenda_ViajesDto get(int id_agenda) {
		return agenda_ViajesRepository.getOne(id_agenda);
	}

	@Override
	public Agenda_ViajesDto update(Agenda_ViajesDto agenda_ViajesDto) {
		return agenda_ViajesRepository.save(agenda_ViajesDto);
	}

	@Override
	public void delete(Agenda_ViajesDto agenda_ViajesDto) {
		agenda_ViajesRepository.delete(agenda_ViajesDto);
	}

	

}

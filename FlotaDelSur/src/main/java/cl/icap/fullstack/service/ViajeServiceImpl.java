package cl.icap.fullstack.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl.icap.fullstack.model.dto.ViajeDto;
import cl.icap.fullstack.model.repository.ViajeRepository;

@Service
public class ViajeServiceImpl implements ViajeService {
	
	@Autowired
	ViajeRepository viajeRepository;
	
	@Override
	public List<ViajeDto> list(){
		return viajeRepository.findAll();
	}

	@Override
	public ViajeDto insert(ViajeDto viajeDto) {
		return viajeRepository.save(viajeDto);
	}

	@Override
	public ViajeDto get(int viaje_id) {
		return viajeRepository.getOne(viaje_id) ;
	}

	@Override
	public ViajeDto update(ViajeDto viajeDto) {
		return viajeRepository.save(viajeDto);
	}

	@Override
	public void delete(ViajeDto viajeDto) {
		 viajeRepository.delete(viajeDto);
	}
	
}

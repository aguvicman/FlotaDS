package cl.icap.fullstack.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl.icap.fullstack.model.dto.ValoresDto;
import cl.icap.fullstack.model.repository.ValoresRepository;


@Service
public class ValoresServiceImpl implements ValoresService {

	@Autowired
	ValoresRepository valoresRepository;
	
	@Override
	public List<ValoresDto> list(){
		return valoresRepository.findAll();
	}

	@Override
	public ValoresDto insert(ValoresDto valoresDto) {
		return valoresRepository.save(valoresDto);
	}

	@Override
	public ValoresDto get(int tramo_id) {
		return valoresRepository.getOne(tramo_id);
	}

	@Override
	public ValoresDto update(ValoresDto valoresDto) {
		return valoresRepository.save(valoresDto);
	}

	@Override
	public void delete(ValoresDto valoresDto) {
		 valoresRepository.delete(valoresDto);
	}
	
}

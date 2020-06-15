package cl.icap.fullstack.service;

import java.util.List;

import cl.icap.fullstack.model.dto.ValoresDto;

public interface ValoresService {
	public ValoresDto insert(ValoresDto valoresDto);
	public ValoresDto get(int tramo_id);
	public ValoresDto update(ValoresDto valoresDto);
	public void delete (ValoresDto ValoresDto);
	public List<ValoresDto> list();

}

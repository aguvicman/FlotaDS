package cl.icap.fullstack.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cl.icap.fullstack.model.dto.ValoresDto;

public interface ValoresRepository extends JpaRepository<ValoresDto, Integer> {

}

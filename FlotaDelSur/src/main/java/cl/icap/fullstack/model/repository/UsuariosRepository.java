package cl.icap.fullstack.model.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import cl.icap.fullstack.model.dto.UsuariosDto;

public interface UsuariosRepository extends JpaRepository<UsuariosDto, Integer> {

	Optional<UsuariosDto> findByUserName(String userName);
}

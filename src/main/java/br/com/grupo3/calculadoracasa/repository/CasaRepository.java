package br.com.grupo3.calculadoracasa.repository;

import br.com.grupo3.calculadoracasa.modelo.Casa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CasaRepository extends JpaRepository<Casa, Long> {
}

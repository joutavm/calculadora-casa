package br.com.grupo3.calculadoracasa.repository;

import br.com.grupo3.calculadoracasa.modelo.Comodo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComodoRepository extends JpaRepository<Comodo, Long> {
}

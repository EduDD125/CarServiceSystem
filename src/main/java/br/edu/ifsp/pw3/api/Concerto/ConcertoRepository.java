package br.edu.ifsp.pw3.api.Concerto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ConcertoRepository extends JpaRepository<Concerto, Long> {
    Page<Concerto> findAllByAtivoTrue(Pageable paginacao);
}

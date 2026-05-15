package cl.duoc.innovatech.recursos.repository;

import cl.duoc.innovatech.recursos.entity.Recurso;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository Pattern (CLAUDE.md §6). Spring Data generates the
// implementation at startup; queries beyond CRUD go here as derived
// methods or @Query.
public interface RecursoRepository extends JpaRepository<Recurso, Long> {

    boolean existsByEmail(String email);
}

package cl.duoc.innovatech.proyectos.bootstrap;

import cl.duoc.innovatech.proyectos.entity.EstadoProyecto;
import cl.duoc.innovatech.proyectos.entity.Proyecto;
import cl.duoc.innovatech.proyectos.repository.ProyectoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

// Dev convenience: insert two sample projects the first time the table
// is empty. Skipped if the `prod` profile is active.
@Component
@Profile("!prod")
public class SeedData implements CommandLineRunner {

    private final ProyectoRepository repository;

    public SeedData(ProyectoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {
        if (repository.count() > 0) {
            return;
        }
        repository.saveAll(List.of(
                new Proyecto(
                        null,
                        "Plataforma Innovatech",
                        "Sistema de gestion interno de proyectos.",
                        EstadoProyecto.EN_CURSO,
                        LocalDate.of(2026, 1, 15),
                        LocalDate.of(2026, 12, 1),
                        "user-pm-test"
                ),
                new Proyecto(
                        null,
                        "Migracion Acme",
                        "Migracion del cliente Acme a infraestructura cloud.",
                        EstadoProyecto.PLANIFICACION,
                        LocalDate.of(2026, 6, 1),
                        LocalDate.of(2026, 10, 15),
                        "user-pm-test"
                )
        ));
    }
}

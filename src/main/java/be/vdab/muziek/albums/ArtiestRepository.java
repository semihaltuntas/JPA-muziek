package be.vdab.muziek.albums;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArtiestRepository extends JpaRepository<Artiest,Long> {
    Optional<Artiest> findById(Long id);
}

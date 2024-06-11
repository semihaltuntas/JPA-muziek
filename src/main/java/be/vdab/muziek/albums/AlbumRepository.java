package be.vdab.muziek.albums;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

interface AlbumRepository extends JpaRepository<Album,Long> {
    @Override
    @EntityGraph(attributePaths = "artiest")
    List<Album> findAll();

    Optional<Album> findById(Long id);

    List<Album> findByJaarOrderByNaam(int jaar);
}

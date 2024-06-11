package be.vdab.muziek.albums;

import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping("artiesten")
public class ArtiestController {
    private final ArtiestService artiestService;

    public ArtiestController(ArtiestService artiestService) {
        this.artiestService = artiestService;
    }
    private record AlbumNaamEnJaar(String naam,int jaar){
        AlbumNaamEnJaar(Album album){
            this(album.getNaam(),album.getJaar());
        }
    }

    @GetMapping("{id}/albums")
    Stream<AlbumNaamEnJaar> findAlbumsById(@PathVariable long id){
        return artiestService.findById(id)
                .map(artiest -> artiest.getAlbums().stream()
                        .map(album -> new AlbumNaamEnJaar(album)))
                .orElseThrow(ArtistNietGevonden::new);
    }
}

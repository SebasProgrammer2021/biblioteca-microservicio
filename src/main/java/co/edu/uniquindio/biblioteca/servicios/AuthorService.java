package co.edu.uniquindio.biblioteca.servicios;

import co.edu.uniquindio.biblioteca.dto.AuthorDTO;
import co.edu.uniquindio.biblioteca.entity.Autor;
import co.edu.uniquindio.biblioteca.repo.AutorRepo;
import co.edu.uniquindio.biblioteca.servicios.excepciones.AuthorNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AuthorService {

    private final AutorRepo authorRepo;

    private AuthorDTO convertAuthorToAuthorDTO(Autor author) {
        return new AuthorDTO(author.getId(), author.getNombre());
    }

    public void delete(Long id) {
        authorRepo.findById(id).orElseThrow(() -> new AuthorNotFoundException("Author not found"));
        authorRepo.deleteById(id);
    }

    public AuthorDTO getAuthorById(String id) {
        Autor autor = authorRepo.findById(Long.valueOf(id)).orElseThrow(() -> new AuthorNotFoundException("Author not found"));
        return convertAuthorToAuthorDTO(autor);
    }

    public Autor save(Autor author) {
        return authorRepo.save(author);
    }

    public Autor update(Long id, Autor author) {
        authorRepo.findById(id).orElseThrow(() -> new AuthorNotFoundException("Author not found"));
        return authorRepo.save(author);
    }

    public List<AuthorDTO> getAllAuthors() {
        return authorRepo.findAll().stream().map(author -> convertAuthorToAuthorDTO(author)).collect(Collectors.toList());
    }

}

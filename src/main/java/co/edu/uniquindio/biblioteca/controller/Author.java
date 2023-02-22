package co.edu.uniquindio.biblioteca.controller;

import co.edu.uniquindio.biblioteca.dto.AuthorDTO;
import co.edu.uniquindio.biblioteca.entity.Autor;
import co.edu.uniquindio.biblioteca.servicios.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/author")
@AllArgsConstructor
public class Author {
    private final AuthorService authorService;

    @DeleteMapping("/{authorId}")
    public String deleteAuthor(@PathVariable Long id) {
        authorService.delete(id);
        return "Author deleted successfully";
    }

    @GetMapping
    public List<AuthorDTO> findAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/{authorId}")
    public AuthorDTO findAuthorById(@PathVariable String id) {
        return authorService.getAuthorById(id);
    }

    @PostMapping
    public Autor saveAuthor(@RequestBody Autor author) {
        return authorService.save(author);
    }

    @PutMapping
    public Autor updateAuthor(@PathVariable Long id, @RequestBody Autor author) {
        return authorService.update(id, author);
    }
}

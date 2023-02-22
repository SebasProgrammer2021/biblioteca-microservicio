package co.edu.uniquindio.biblioteca.servicios;

import co.edu.uniquindio.biblioteca.dto.BookDTO;
import co.edu.uniquindio.biblioteca.entity.Libro;
import co.edu.uniquindio.biblioteca.repo.LibroRepo;
import co.edu.uniquindio.biblioteca.servicios.excepciones.BookNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Sebastián Londoño Valencia
 * @date: 20-02-2023
 */

@Service
@AllArgsConstructor
public class BookService {
    private final LibroRepo bookRepo;

    private BookDTO convertBookToBookDTO(Libro book) {
        return new BookDTO(book.getIsbn(), book.getNombre(), book.getGenero());
    }

    public void delete(String isbn) {
        bookRepo.findById(isbn).orElseThrow(() -> new BookNotFoundException("Book not found"));
        bookRepo.deleteById(isbn);
    }

    public BookDTO findById(String isbn) {
        Libro book = bookRepo.findById(isbn).orElseThrow(() -> new BookNotFoundException("Book not found"));

        return convertBookToBookDTO(book);
    }

    public Libro save(Libro book) {
        return bookRepo.save(book);
    }

    public Libro update(String isbn, Libro book) {
        bookRepo.findById(isbn).orElseThrow(() -> new BookNotFoundException("Book not found"));
        return bookRepo.save(book);
    }

    public List<BookDTO> findAll() {
        return bookRepo.findAll().stream().map(book -> convertBookToBookDTO(book)).collect(Collectors.toList());
    }
}

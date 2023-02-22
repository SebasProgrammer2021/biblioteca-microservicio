package co.edu.uniquindio.biblioteca.controller;

import co.edu.uniquindio.biblioteca.dto.BookDTO;
import co.edu.uniquindio.biblioteca.entity.Libro;
import co.edu.uniquindio.biblioteca.servicios.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
@AllArgsConstructor
public class Book {
    private final BookService bookService;

    @DeleteMapping("/{bookId}")
    public String deleteBook(@PathVariable String bookId) {
        bookService.delete(bookId);
        return "Book deleted successfully";
    }

    @GetMapping
    public List<BookDTO> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/{bookId}")
    public BookDTO findById(@PathVariable String bookId) {
        return bookService.findById(bookId);
    }

    @PostMapping
    public Libro saveBook(@RequestBody Libro book) {
        return bookService.save(book);
    }

    @PutMapping("/{bookId}")
    public Libro updateBook(@PathVariable String bookId, @RequestBody Libro book) {
        return bookService.update(bookId, book);
    }

}

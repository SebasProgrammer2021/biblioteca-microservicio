package co.edu.uniquindio.biblioteca.dto;

import co.edu.uniquindio.biblioteca.entity.Cliente;
import co.edu.uniquindio.biblioteca.entity.Libro;

import java.time.LocalDateTime;
import java.util.List;

public record LoanDTO(long clienteID, List<String> isbnLibros, LocalDateTime fechaDevolucion) {
}

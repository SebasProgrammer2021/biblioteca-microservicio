package co.edu.uniquindio.biblioteca.servicios.excepciones;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String message) {
        super(message);
    }
}

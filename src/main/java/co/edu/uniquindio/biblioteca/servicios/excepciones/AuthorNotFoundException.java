package co.edu.uniquindio.biblioteca.servicios.excepciones;

public class AuthorNotFoundException extends RuntimeException {
    public AuthorNotFoundException(String message) {
        super(message);
    }
}

package co.edu.uniquindio.biblioteca.servicios.excepciones;

public class LoanNotFoundException extends RuntimeException {
    public LoanNotFoundException(String message) {
        super(message);
    }
}

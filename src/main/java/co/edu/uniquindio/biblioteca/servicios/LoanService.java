package co.edu.uniquindio.biblioteca.servicios;

import co.edu.uniquindio.biblioteca.dto.LoanDTO;
import co.edu.uniquindio.biblioteca.entity.Cliente;
import co.edu.uniquindio.biblioteca.entity.Libro;
import co.edu.uniquindio.biblioteca.entity.Prestamo;
import co.edu.uniquindio.biblioteca.repo.ClienteRepo;
import co.edu.uniquindio.biblioteca.repo.PrestamoRepo;
import co.edu.uniquindio.biblioteca.servicios.excepciones.ClienteNoEncontradoException;
import co.edu.uniquindio.biblioteca.servicios.excepciones.LoanNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Sebastián Londoño Valencia
 * @date: 20-02-2023
 */
@Service
@AllArgsConstructor
public class LoanService {
    public final PrestamoRepo loanRepo;
    public final ClienteRepo customerRepo;

//    public LoanDTO convertLoanToLoanDTO(Prestamo loan) {
//        return new LoanDTO(
//                loan.getCodigo(), loan.getCodigoCliente(), loan.getFechaPrestamo(), loan.getFechaDevolucion(), loan.getLibros()
//        );
//    }

    public void deleteLoan(String loanId) {
        loanRepo.findById(Long.valueOf(loanId)).orElseThrow(() -> new LoanNotFoundException("Loan " + loanId + " not found"));
    }

    public Prestamo save(LoanDTO loanDTO) {

        long codigoCliente = loanDTO.clienteID();
        Optional<Cliente> consulta = customerRepo.findById(codigoCliente);

        if(consulta.isEmpty()){
            throw new ClienteNoEncontradoException("No existe");
        }

        Prestamo prestamo = new Prestamo();
        prestamo.setCliente(consulta.get());
        prestamo.setFechaPrestamo(LocalDateTime.now());

        List<String> codigosLibros = loanDTO.isbnLibros();
        List<Libro> libros = new ArrayList<>();

        /*Optional<Libro> buscado libroRepo.findById(codigosLibros[0]);

        if(buscado.isEmpty()){
            throw new LibroNoExiste("El libro no existe");
        }

        libros.add( buscado );*/

        //TODO Completar la parte de los libros
        prestamo.setLibros(libros);
        prestamo.setFechaDevolucion(loanDTO.fechaDevolucion());

        return loanRepo.save(prestamo);
    }


    //TODO Completar
    public List<LoanDTO> findByCodigoCliente(long codigoCliente){

        return null;
    }

    //TODO usar DTO y la exepción propia de préstamo
    public Prestamo findById(long codigoPrestamo){
        return loanRepo.findById(codigoPrestamo).orElseThrow(()-> new RuntimeException("No existe"));
    }

}

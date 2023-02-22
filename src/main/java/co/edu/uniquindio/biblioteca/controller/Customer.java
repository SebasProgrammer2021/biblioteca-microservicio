package co.edu.uniquindio.biblioteca.controller;

import co.edu.uniquindio.biblioteca.dto.ClienteGet;
import co.edu.uniquindio.biblioteca.dto.CustomerPost;
import co.edu.uniquindio.biblioteca.dto.Response;
import co.edu.uniquindio.biblioteca.servicios.ClienteServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
@AllArgsConstructor
public class Customer {

    private final ClienteServicio clienteServicio;

    @PostMapping
    public ResponseEntity<Response<ClienteGet>> save(@RequestBody CustomerPost cliente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new Response<>("Cliente creado correctamente", clienteServicio.save(cliente)));
    }

    @GetMapping("/{idCliente}")
    public ResponseEntity<Response<ClienteGet>> findById(@PathVariable long idCliente) {
        return ResponseEntity.status(HttpStatus.OK).body(new Response<>("", clienteServicio.findById(idCliente)));
    }

    @GetMapping
    public ResponseEntity<Response<List<ClienteGet>>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(new Response<>("", clienteServicio.findAll()));

    }

    @DeleteMapping("/{idCliente}")
    public ResponseEntity<Response<String>> delete(@PathVariable long idCliente) {
        clienteServicio.delete(idCliente);
        return ResponseEntity.status(HttpStatus.OK).body(new Response<>("Se eliminó correctamente"));
    }


    @PutMapping("/{idCliente}")
    public ResponseEntity<Response<ClienteGet>> update(@PathVariable long idCliente, @RequestBody CustomerPost cliente) {
        return ResponseEntity.status(HttpStatus.OK).body(new Response<>("El cliente se modificó correctamente", clienteServicio.update(idCliente, cliente)));
    }


}

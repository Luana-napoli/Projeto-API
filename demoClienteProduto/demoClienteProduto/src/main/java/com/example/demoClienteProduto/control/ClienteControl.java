package com.example.demoClienteProduto.control;


import com.example.demoClienteProduto.model.Cliente;
import com.example.demoClienteProduto.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apiCliente")
public class ClienteControl {

    @Autowired
    ClienteRepository cRepo;

    @PostMapping("/inserir")
    public void inserirCliente (@RequestBody Cliente c){
        cRepo.save(c);
    }

    @GetMapping("/cliente/{id}")
    public Optional<Cliente> buscarClientePorId(@PathVariable(value= "id") int id)
    {
        return cRepo.findById(id);
    }

    @GetMapping("/buscar/parteNome/{parte}")
    public List<Cliente> findByParteNome(@PathVariable String parte){
        return cRepo.findByParteNome(parte);
    }

    @PutMapping("/atualizar")
    public void atualizarCliente (@RequestBody Cliente c){
        cRepo.save(c);
    }

    @DeleteMapping("/removerPorId/{id}")
    public void removerPorId(@PathVariable(value= "id")int id)
    {
        cRepo.deleteById(id);
    }



}
package com.example.demoClienteProduto.control;


import com.example.demoClienteProduto.model.Cliente;
import com.example.demoClienteProduto.model.Produto;
import com.example.demoClienteProduto.repository.ClienteRepository;
import com.example.demoClienteProduto.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apiProduto")
public class ProdutoContol {
    @Autowired
   ProdutoRepository pRepo;

    @PostMapping("/inserir")
    public void inserirProduto (@RequestBody Produto p){
        pRepo.save(p);
    }

    @GetMapping("/buscarTodos")
    public List<Produto> buscarTodos(){
        return pRepo.findAll();
    }

    @GetMapping("/produto/{id}")
    public Optional<Produto> buscarProdutoPorId(@PathVariable(value= "id") int id)
    {
        return pRepo.findById(id);
    }

    @GetMapping("/buscar/parteDescricao/{parte}")
    public List<Produto> findByParteDescricao(@PathVariable String parte){
        return pRepo.findByParteDescricao(parte);
    }

    @PutMapping("/atualizar")
    public void atualizarProduto (@RequestBody Produto p){
        pRepo.save(p);
    }

    @DeleteMapping("/removerPorId/{id}")
    public void removerPorId(@PathVariable(value= "id")int id)
    {
        pRepo.deleteById(id);
    }

    @GetMapping("buscar/buscaPrecoMenor/{preco}")
    public List<Produto> findPrecoMenor(@PathVariable double preco){
        return pRepo.findPrecoMenor(preco);
    }

    @GetMapping("/buscar/marca/{marca}")
    public List<Produto> findByMarca(@PathVariable String marca){
        return pRepo.findByMarca(marca);
    }

    @DeleteMapping("/removerPorRegistro")
    public void removerPorRegistro(@RequestBody Produto p)
    {
        pRepo.delete(p);
    }

    @GetMapping("buscar/buscaParteMarcaPrecoMenor/{parte}/{preco}")
    public List<Produto> findParteMarcaPrecoMenor(@PathVariable String parte, @PathVariable double preco){
        return pRepo.findParteMarcaPrecoMenor(parte, preco);
    }

}

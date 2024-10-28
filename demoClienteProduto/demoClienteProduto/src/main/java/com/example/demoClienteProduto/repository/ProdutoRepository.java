package com.example.demoClienteProduto.repository;

import com.example.demoClienteProduto.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    @Query("select p from Produto p where p.descricao like %?1%")
    List<Produto> findByParteDescricao(String parte);

    @Query("select p from Produto p where p.preco < ?1")
    List<Produto> findPrecoMenor(double preco);

    @Query("select p from Produto p where p.marca like ?1")
    List<Produto> findByMarca(String marca);

    @Query("select p from Produto p where p.marca like %?1% and p.preco < ?2")
    List<Produto> findParteMarcaPrecoMenor(String marca, double preco);
}

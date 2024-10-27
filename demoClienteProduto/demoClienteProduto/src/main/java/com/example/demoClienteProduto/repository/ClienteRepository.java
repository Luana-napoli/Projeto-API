package com.example.demoClienteProduto.repository;

import com.example.demoClienteProduto.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

   @Query("select c from Cliente c where c.nome like ?1%")
    public List<Cliente> findByParteNome(String parte);
}

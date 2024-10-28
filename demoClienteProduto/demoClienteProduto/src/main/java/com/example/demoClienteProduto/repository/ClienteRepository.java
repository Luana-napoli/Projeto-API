package com.example.demoClienteProduto.repository;

import com.example.demoClienteProduto.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

   @Query("select c from Cliente c where c.nome like ?1%")
    public List<Cliente> findByParteNome(String parte);

    public Optional<Cliente> findByEmail(String email);

    @Query("select c from Cliente c where c.nome like %?1% and c.email like %?2%")
    public List<Cliente> findByParteNomeEEmail(String parteNome, String parteEmail);
}

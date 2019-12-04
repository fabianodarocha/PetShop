package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("select a From Cliente a WHERE a.nome like :nome ")
    List<Cliente> buscaPorNome(@Param("nome") String nome);

    @Query("select a From Cliente a WHERE a.cpf like :cpf ")
    List<Cliente> buscaPorCpf(@Param("cpf") String cpf);

    @Query("select a From Cliente a WHERE a.nome like :nome or a.cpf like :cpf ")
    List<Cliente> buscaPorNomeCpf(@Param("nome") String nome, @Param("cpf") String cpf);


}

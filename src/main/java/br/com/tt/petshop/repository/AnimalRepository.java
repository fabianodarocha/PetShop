package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

    //@Query("select a From Animal a WHERE a.nome like :nomeAnimal ")
   // List<Animal> listarPorNome(@Param("nomeAnimal") String nome);
}

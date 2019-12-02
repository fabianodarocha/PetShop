package br.com.tt.petshop.service;

import br.com.tt.petshop.exceptions.NegocioException;
import br.com.tt.petshop.exceptions.RegistroNaoExisteException;
import br.com.tt.petshop.model.Unidade;
import br.com.tt.petshop.repository.UnidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadeService {

    private final UnidadeRepository unidadeRepository;

    public UnidadeService(UnidadeRepository unidadeRepository) {
        this.unidadeRepository = unidadeRepository;
    }

    public List<Unidade> listar() {
        return unidadeRepository.findAll();
    }

    public Unidade salvar(Unidade unidade) throws NegocioException {
        return unidadeRepository.save(unidade);
    }

    public void deletar(Long id) {
        unidadeRepository.deleteById(id);
    }

    public Unidade buscarPorId(Long id) {
        return unidadeRepository.findById(id)
                .orElseThrow(() -> new RegistroNaoExisteException("Unidade não existe"));
    }

}

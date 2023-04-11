package br.com.fiap.cde.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.cde.models.Estoque;
import br.com.fiap.cde.repository.EstoqueRepository;
import br.com.fiap.cde.repository.ProdutoRepository;

@Configuration
public class DatabaseSeeder implements CommandLineRunner{

    @Autowired
    private ProdutoRepository produtoRepository;
    
    @Autowired
    private EstoqueRepository estoqueRepository;

    @Override
    public void run(String... args) throws Exception {
        estoqueRepository.saveAll(List.of(
            new Estoque(1L, "Estoque 1", "Descricao do estoque 1"),
            new Estoque(2L, "Estoque 2", "Descricao do estoque 2"),
            new Estoque(3L, "Estoque 3", "Descricao do estoque 3"),
            new Estoque(4L, "Estoque 4", "Descricao do estoque 4")
        ));
         
    }
    
}

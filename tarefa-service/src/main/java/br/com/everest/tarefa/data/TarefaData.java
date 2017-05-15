package br.com.everest.tarefa.data;

import br.com.everest.tarefa.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Joao on 11/05/2017.
 */

@Repository
public interface TarefaData extends JpaRepository<Tarefa, Long> {

    List<Tarefa> findByGuardadaFalse();

    List<Tarefa> findTop5ByOrderByCriacaoDesc();
}

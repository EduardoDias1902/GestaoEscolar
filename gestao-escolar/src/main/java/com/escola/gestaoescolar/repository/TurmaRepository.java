package com.escola.gestaoescolar.repository;

import com.escola.gestaoescolar.dto.TurmaResponseDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TurmaRepository {

    private final JdbcTemplate jdbc;

    public TurmaRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<TurmaResponseDTO> listar(){

        String sql = """
        SELECT t.id,t.nome,
        c.nome AS curso,
        p.nome AS professor
        FROM turma t
        JOIN curso c ON c.id = t.curso_id
        JOIN professor p ON p.id = t.professor_id
        """;

        return jdbc.query(sql,(rs,rowNum)-> new TurmaResponseDTO(
                rs.getLong("id"),
                rs.getString("nome"),
                rs.getString("curso"),
                rs.getString("professor"),
                List.of()
        ));
    }

    public void criar(String nome,Long cursoId,Long professorId){

        String sql = """
        INSERT INTO turma(nome,curso_id,professor_id)
        VALUES(?,?,?)
        """;

        jdbc.update(sql,nome,cursoId,professorId);
    }

}
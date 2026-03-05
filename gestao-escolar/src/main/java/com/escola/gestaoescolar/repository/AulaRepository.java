package com.escola.gestaoescolar.repository;

import com.escola.gestaoescolar.dto.AulaResponseDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AulaRepository {

    private final JdbcTemplate jdbc;

    public AulaRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<AulaResponseDTO> listar(){

        String sql = """
        SELECT a.id,t.nome AS turma,a.data_hora,a.assunto
        FROM aula a
        JOIN turma t ON t.id = a.turma_id
        """;

        return jdbc.query(sql,(rs,rowNum)-> new AulaResponseDTO(
                rs.getLong("id"),
                rs.getString("turma"),
                rs.getTimestamp("data_hora").toLocalDateTime(),
                rs.getString("assunto")
        ));
    }

    public void criar(Long turmaId,String dataHora,String assunto){

        String sql = """
        INSERT INTO aula(turma_id,data_hora,assunto)
        VALUES(?,?,?)
        """;

        jdbc.update(sql,turmaId,dataHora,assunto);
    }

}
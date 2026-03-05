package com.escola.gestaoescolar.repository;

import com.escola.gestaoescolar.dto.NotaResponseDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NotaRepository {

    private final JdbcTemplate jdbc;

    public NotaRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<NotaResponseDTO> listar(){

        String sql = """
        SELECT n.id,
        a.nome AS aluno,
        au.assunto,
        n.valor
        FROM nota n
        JOIN aluno a ON a.id = n.aluno_id
        JOIN aula au ON au.id = n.aula_id
        """;

        return jdbc.query(sql,(rs,rowNum)-> new NotaResponseDTO(
                rs.getLong("id"),
                rs.getString("aluno"),
                rs.getString("assunto"),
                rs.getDouble("valor")
        ));
    }

    public void criar(Long alunoId,Long aulaId,Double valor){

        String sql = """
        INSERT INTO nota(aluno_id,aula_id,valor)
        VALUES(?,?,?)
        """;

        jdbc.update(sql,alunoId,aulaId,valor);
    }

}
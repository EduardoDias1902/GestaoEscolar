package com.escola.gestaoescolar.repository;

import com.escola.gestaoescolar.dto.ProfessorResponseDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProfessorRepository {

    private final JdbcTemplate jdbc;

    public ProfessorRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<ProfessorResponseDTO> listar() {

        String sql = """
        SELECT id,nome,email,disciplina
        FROM professor
        """;

        return jdbc.query(sql, (rs, rowNum) -> new ProfessorResponseDTO(
                rs.getLong("id"),
                rs.getString("nome"),
                rs.getString("email"),
                rs.getString("disciplina")
        ));
    }

    public ProfessorResponseDTO buscarPorId(Long id) {

        String sql = """
        SELECT id,nome,email,disciplina
        FROM professor
        WHERE id = ?
        """;

        return jdbc.queryForObject(sql, (rs, rowNum) -> new ProfessorResponseDTO(
                rs.getLong("id"),
                rs.getString("nome"),
                rs.getString("email"),
                rs.getString("disciplina")
        ), id);
    }

    public void criar(String nome, String email, String disciplina) {

        String sql = """
        INSERT INTO professor(nome,email,disciplina)
        VALUES(?,?,?)
        """;

        jdbc.update(sql, nome, email, disciplina);
    }

    public void atualizar(Long id, String nome, String email, String disciplina) {

        String sql = """
        UPDATE professor
        SET nome = ?, email = ?, disciplina = ?
        WHERE id = ?
        """;

        jdbc.update(sql, nome, email, disciplina, id);
    }

    public void deletar(Long id) {

        String sql = "DELETE FROM professor WHERE id = ?";

        jdbc.update(sql, id);
    }

}
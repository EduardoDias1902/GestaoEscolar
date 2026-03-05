package com.escola.gestaoescolar.repository;

import com.escola.gestaoescolar.dto.CursoResponseDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CursoRepository {

    private final JdbcTemplate jdbc;

    public CursoRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<CursoResponseDTO> listar() {

        String sql = """
        SELECT id, nome, codigo
        FROM curso
        """;

        return jdbc.query(sql, (rs, rowNum) -> new CursoResponseDTO(
                rs.getLong("id"),
                rs.getString("nome"),
                rs.getString("codigo"),
                List.of()
        ));
    }

    public CursoResponseDTO buscarPorId(Long id) {

        String sql = """
        SELECT id, nome, codigo
        FROM curso
        WHERE id = ?
        """;

        return jdbc.queryForObject(sql, (rs, rowNum) -> new CursoResponseDTO(
                rs.getLong("id"),
                rs.getString("nome"),
                rs.getString("codigo"),
                List.of()
        ), id);
    }

    public void criar(String nome, String codigo) {

        String sql = """
        INSERT INTO curso(nome, codigo)
        VALUES (?, ?)
        """;

        jdbc.update(sql, nome, codigo);
    }

    public void atualizar(Long id, String nome, String codigo) {

        String sql = """
        UPDATE curso
        SET nome = ?, codigo = ?
        WHERE id = ?
        """;

        jdbc.update(sql, nome, codigo, id);
    }

    public void deletar(Long id) {

        String sql = "DELETE FROM curso WHERE id = ?";

        jdbc.update(sql, id);
    }

}
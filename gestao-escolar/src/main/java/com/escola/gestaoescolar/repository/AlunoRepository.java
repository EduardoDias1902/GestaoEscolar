package com.escola.gestaoescolar.repository;

import com.escola.gestaoescolar.dto.AlunoResponseDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlunoRepository {

    private final JdbcTemplate jdbc;

    public AlunoRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<AlunoResponseDTO> listarTodos(){

        String sql = """
                SELECT id, nome, email, matricula, data_nascimento
                FROM aluno
                """;

        return jdbc.query(sql,(rs,rowNum)-> new AlunoResponseDTO(
                rs.getLong("id"),
                rs.getString("nome"),
                rs.getString("email"),
                rs.getString("matricula"),
                rs.getDate("data_nascimento").toLocalDate()
        ));
    }

    public AlunoResponseDTO buscarPorId(Long id){

        String sql = """
                SELECT id, nome, email, matricula, data_nascimento
                FROM aluno
                WHERE id = ?
                """;

        return jdbc.queryForObject(sql,(rs,rowNum)-> new AlunoResponseDTO(
                rs.getLong("id"),
                rs.getString("nome"),
                rs.getString("email"),
                rs.getString("matricula"),
                rs.getDate("data_nascimento").toLocalDate()
        ),id);
    }

    public void salvar(String nome,String email,String matricula,String dataNascimento){

        String sql = """
                INSERT INTO aluno(nome,email,matricula,data_nascimento)
                VALUES(?,?,?,?)
                """;

        jdbc.update(sql,nome,email,matricula,dataNascimento);
    }

    public void deletar(Long id){

        String sql = "DELETE FROM aluno WHERE id=?";

        jdbc.update(sql,id);
    }

}
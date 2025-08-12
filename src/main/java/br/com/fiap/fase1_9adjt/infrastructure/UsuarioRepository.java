package br.com.fiap.fase1_9adjt.infrastructure;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.fase1_9adjt.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByLoginAndSenha(String login, String senha);
}


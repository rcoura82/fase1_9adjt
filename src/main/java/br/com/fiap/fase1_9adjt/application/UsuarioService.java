package br.com.fiap.fase1_9adjt.application;

import br.com.fiap.fase1_9adjt.domain.Usuario;

public interface UsuarioService {
    Usuario criarUsuario(Usuario usuario);
    Usuario atualizarUsuario(Long id, Usuario usuario);
    void trocarSenha(Long id, String senhaAtual, String novaSenha);
    boolean validarLogin(String usuario, String senha);
}

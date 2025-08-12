package br.com.fiap.fase1_9adjt.application;


import br.com.fiap.fase1_9adjt.domain.Usuario;
import br.com.fiap.fase1_9adjt.infrastructure.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario criarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario atualizarUsuario(Long id, Usuario usuario) {
        Usuario existente = usuarioRepository.findById(id).orElseThrow();
        existente.setNome(usuario.getNome());
        existente.setEmail(usuario.getEmail());
        existente.setEndereco(usuario.getEndereco());
        existente.setDataUltimaAlteracao(new java.util.Date());
        return usuarioRepository.save(existente);
    }

    @Override
    public void trocarSenha(Long id, String senhaAtual, String novaSenha) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow();
        if (!usuario.getSenha().equals(senhaAtual)) {
            throw new IllegalArgumentException("Senha atual incorreta");
        }
        usuario.setSenha(novaSenha);
        usuario.setDataUltimaAlteracao(new java.util.Date());
        usuarioRepository.save(usuario);
    }

    @Override
    public boolean validarLogin(String usuario, String senha) {
        return usuarioRepository.findByLoginAndSenha(usuario, senha).isPresent();
    }
}

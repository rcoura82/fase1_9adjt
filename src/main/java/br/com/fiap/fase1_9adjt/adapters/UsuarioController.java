package br.com.fiap.fase1_9adjt.adapters;

import br.com.fiap.fase1_9adjt.application.UsuarioService;
import br.com.fiap.fase1_9adjt.domain.LoginRequest;
import br.com.fiap.fase1_9adjt.domain.TrocaSenhaRequest;
import br.com.fiap.fase1_9adjt.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public Usuario criarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.criarUsuario(usuario);
    }

    @PutMapping("/{id}")
    public Usuario atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        return usuarioService.atualizarUsuario(id, usuario);
    }

    @PostMapping("/troca-senha")
    public String trocarSenha(@RequestBody TrocaSenhaRequest request) {
        usuarioService.trocarSenha(1L, request.getSenhaAtual(), request.getNovaSenha());
        return "Senha alterada com sucesso!";
    }

    @PostMapping("/login")
    public String validarLogin(@RequestBody LoginRequest request) {
        boolean valido = usuarioService.validarLogin(request.getUsuario(), request.getSenha());
        return valido ? "Login válido!" : "Login inválido!";
    }
}
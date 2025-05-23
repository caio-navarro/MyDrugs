package com.site.mydrugs.application;

import java.util.List;
import java.util.Optional;

import com.site.mydrugs.models.PapelModels;
import com.site.mydrugs.repositories.PapelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import com.site.mydrugs.entities.Cliente;
import com.site.mydrugs.models.ClienteModels;
import com.site.mydrugs.models.EnderecoClienteModels;
import com.site.mydrugs.repositories.ClienteRepository;
import com.site.mydrugs.repositories.EnderecoClienteRepository;

@Component
public class ClienteApplication {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoClienteRepository enderecoRepository;

    @Autowired
    private PapelRepository papelRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseEntity<?> cadastrar(ClienteModels clienteModels) {
        try {
            Cliente cliente = Cliente.toCliente(clienteModels);
            cliente.validar();

            ClienteModels clienteSecurity = new ClienteModels(
                    cliente.getNome(),
                    cliente.getEmail(),
                    cliente.getSenha());

            // Codificar a senha SEM o prefixo {bcrypt}
            // O Spring Security vai gerenciar isso automaticamente
            clienteSecurity.setSenha(passwordEncoder.encode(clienteSecurity.getSenha()));

            clienteRepository.save(clienteSecurity);

            PapelModels papel = new PapelModels();
            papel.setPapel("ROLE_USUARIO");  // papel fixo, padrão
            papel.setIdCliente(clienteSecurity.getIdCliente());

            papelRepository.save(papel);

            return ResponseEntity.ok("Cadastrado com sucesso!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro inesperado no servidor." + e.getMessage());
        }
    }

    public List<ClienteModels> listar() {
        return clienteRepository.findAll();
    }

    public ClienteModels buscar(Integer id) {
        return clienteRepository.findById(id).get();
    }

    public ResponseEntity<ClienteModels> atualizar(ClienteModels clienteRequest) {
        Optional<ClienteModels> clienteExistente = clienteRepository.findById(clienteRequest.getIdCliente());

        if (clienteExistente.isPresent()) {
            ClienteModels cliente = clienteExistente.get();

            cliente.setNome(clienteRequest.getNome());
            cliente.setEmail(clienteRequest.getEmail());
            cliente.setTelefone(clienteRequest.getTelefone());

            // Atualizar o endereço se ele já existir
            if (clienteRequest.getEndereco() != null) {
                if (clienteRequest.getEndereco().getIdEnderecoCliente() != null) {
                    // Caso 1: Atualizar um endereço existente
                    Optional<EnderecoClienteModels> enderecoExistente = enderecoRepository
                            .findById(clienteRequest.getEndereco().getIdEnderecoCliente());

                    if (enderecoExistente.isPresent()) {
                        EnderecoClienteModels endereco = enderecoExistente.get();
                        endereco.setLogradouro(clienteRequest.getEndereco().getLogradouro());
                        endereco.setNumero(clienteRequest.getEndereco().getNumero());
                        endereco.setCep(clienteRequest.getEndereco().getCep());
                        endereco.setCidade(clienteRequest.getEndereco().getCidade());
                        endereco.setEstado(clienteRequest.getEndereco().getEstado());

                        endereco = enderecoRepository.save(endereco);

                        // Definir manualmente o ID do endereço na coluna do cliente
                        cliente.setIdEnderecoCliente(endereco.getIdEnderecoCliente());
                    }
                } else {
                    // Caso 2: Criar um novo endereço
                    EnderecoClienteModels novoEndereco = clienteRequest.getEndereco();
                    novoEndereco = enderecoRepository.save(novoEndereco);

                    // Definir manualmente o ID do novo endereço na coluna do cliente
                    cliente.setIdEnderecoCliente(novoEndereco.getIdEnderecoCliente());
                }
            }

            // Salvar o cliente atualizado
            cliente = clienteRepository.save(cliente);
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public void deletar(Integer id) {
        clienteRepository.deleteById(id);
    }

    public Optional<ClienteModels> buscarPorEmail(String email) {
        return clienteRepository.findByEmail(email);
    }

    public String login(ClienteModels cliente) {
        Optional<ClienteModels> clienteEncontrado = this.buscarPorEmail(cliente.getEmail());

        if (clienteEncontrado.isPresent()) {
            ClienteModels clienteDb = clienteEncontrado.get();

            // Verificar se a senha fornecida confere com a senha criptografada no banco
            if (passwordEncoder.matches(cliente.getSenha(), clienteDb.getSenha())) {
                return "Login realizado com sucesso!";
            }
        }

        return "Credenciais inválidas!";
    }
}
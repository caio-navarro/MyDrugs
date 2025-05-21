package com.site.mydrugs.application;

import com.site.mydrugs.entities.Droga;
import com.site.mydrugs.models.DrogaModels;
import com.site.mydrugs.repositories.DrogaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.util.List;

@Component
public class DrogaApplication {

    @Autowired
    private DrogaRepository drogaRepository;

    public DrogaModels cadastrar(DrogaModels drogaModels) {
        Droga droga = Droga.toDroga(drogaModels);
        droga.validar();
        return drogaRepository.save(drogaModels);
    }

    public DrogaModels atualizar(DrogaModels drogaModels) {
        return drogaRepository.save(drogaModels);
    }

    public List<DrogaModels> listar() {
        return drogaRepository.findAll();
    }

    public DrogaModels buscar(int id) {
        return drogaRepository.findById(id).get();
    }

    public void deletar(int id) {
        drogaRepository.deleteById(id);
    }

    private String salvarImagem(MultipartFile imagem) {
        try {
            String nomeArquivo = System.currentTimeMillis() + "-" + imagem.getOriginalFilename();
            String caminhoDiretorio = new File("src/main/resources/static/imagens").getAbsolutePath();
            File destino = new File(caminhoDiretorio, nomeArquivo);
            
            imagem.transferTo(destino);
    
            return "http://localhost:8080/imagens/" + nomeArquivo;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar imagem", e);
        }
    }
}

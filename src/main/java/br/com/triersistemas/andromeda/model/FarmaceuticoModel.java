package br.com.triersistemas.andromeda.model;

import br.com.triersistemas.andromeda.domain.Farmaceutico;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class FarmaceuticoModel {

    private UUID id;
    private String nome;
    private LocalDate niver;
    private String cpf;
    private String ofertaDia;

    private Long idade;
    private String documento;
    private Boolean documentoValido;

    public static String getRandomMed() {
        List<String> lista = new ArrayList<>();
        lista.add("Dipirona");
        lista.add("Frauda Anjinho");
        lista.add("Dove my care");
        lista.add("Trident");
        lista.add("Paracetamol");
        lista.add("Rivotril");
        lista.add("Cloridrato de paroxetina");
        lista.add("Valium");
        lista.add("Valeriana");
        lista.add("Floral");
        lista.add("Dramin");
        var r = new SplittableRandom();
        return lista.get(r.nextInt(0, lista.size()));
    }

    public FarmaceuticoModel(Farmaceutico farmaceutico){
        this.id = farmaceutico.getId();
        this.nome = farmaceutico.getNome();
        this.niver = farmaceutico.getNiver();
        this.ofertaDia = farmaceutico.getOfertaDia();
        this.cpf = farmaceutico.getDocumento();
        this.documento = farmaceutico.getDocumento();
        this.idade = farmaceutico.getIdade();
        this.documentoValido = farmaceutico.getDocumentoValido();
    }
}
package br.uniesp.si.techback.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Data getter e setter juntos
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Genero {
    private int Id;
    private String Nome;
    private String Descricao;
}

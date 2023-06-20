package com.rc20.agendador.enuns;

import static java.util.Arrays.asList;
import java.util.Objects;

/**
 *
 * @author Desenv. 02
 */
public enum Themes {
    BARBEARIA(1, "Barbearia"), 
    MANICURE(2, "Manicure"), 
    SALAO_DE_BELEZA(3, "Salão de Beleza");
    
    private Integer id;
    private String desc;

    private Themes(Integer id, String name) {
        this.id = id;
        this.desc = name;
    }

    public Integer getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }
    
    public static Themes get(Integer id){
        return asList(values())
                .stream()
                .filter(x -> Objects.equals(x.id, id))
                .findFirst()
                .get();
    }
    
}

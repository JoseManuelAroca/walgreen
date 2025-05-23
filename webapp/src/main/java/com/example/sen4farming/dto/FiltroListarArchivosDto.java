package com.example.sen4farming.dto;

import com.example.sen4farming.model.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FiltroListarArchivosDto {

    private Integer id;
    private String reference;
    private String dateIni;
    private String dateFin;
    private String polygon;
    private long cloudCover;
    private Integer nunberOfResults;
    private boolean removePrevData;
    private Usuario usuariofiltro;

}

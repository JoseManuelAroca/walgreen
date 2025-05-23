package com.example.sen4farming.service.mapper;

import com.example.sen4farming.dto.EvalScriptDto;
import com.example.sen4farming.dto.PythonScriptDto;
import com.example.sen4farming.model.PythonScript;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class PythonScriptMapper extends AbstractServiceMapper<PythonScript, PythonScriptDto> {
    //Convertir de entidad a dto
    @Override
    public PythonScriptDto toDto(PythonScript entidad){
        final PythonScriptDto dto = new PythonScriptDto();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(entidad,dto);
        return dto;
    }
    //Convertir de dto a entidad
    @Override
    public PythonScript toEntity(PythonScriptDto dto){
        final PythonScript entidad = new PythonScript();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto,entidad);
        return entidad;
    }
}

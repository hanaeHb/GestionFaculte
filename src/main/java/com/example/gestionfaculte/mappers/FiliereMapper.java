package com.example.gestionfaculte.mappers;

import com.example.gestionfaculte.dto.RequestFiliereDto;
import com.example.gestionfaculte.dto.ResponceFiliereDto;
import com.example.gestionfaculte.entity.Filiere;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class FiliereMapper {

    public Filiere DTO_TO_ENTITY(RequestFiliereDto requestFiliereDto) {
        Filiere filiere = new Filiere();
        BeanUtils.copyProperties(requestFiliereDto, filiere);
        return filiere;
    }

    public ResponceFiliereDto ENTITY_TO_DTO(Filiere filiere) {
        ResponceFiliereDto responceFiliereDto = new ResponceFiliereDto();
        BeanUtils.copyProperties(filiere, responceFiliereDto);
        return responceFiliereDto;

    }
}

package elhakki.ossama.keynoteservice.mappers;

import elhakki.ossama.keynoteservice.dtos.KeynoteDTO;
import elhakki.ossama.keynoteservice.entities.Keynote;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface KeynoteMapper {
    KeynoteMapper INSTANCE = Mappers.getMapper(KeynoteMapper.class);
    KeynoteDTO keynoteToKeynoteDTO(Keynote keynote);
    Keynote keynoteDTOToKeynote(KeynoteDTO keynoteDTO);
}

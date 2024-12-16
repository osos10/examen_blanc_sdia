package elhakki.ossama.conferenceservice.mappers;

import elhakki.ossama.conferenceservice.dtos.ConferenceDTO;
import elhakki.ossama.conferenceservice.entities.Conference;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ConferenceMapper {
    ConferenceMapper INSTANCE = Mappers.getMapper(ConferenceMapper.class);
    ConferenceDTO conferenceToConferenceDTO(Conference conference);
    Conference conferenceDTOToConference(ConferenceDTO conferenceDTO);
}

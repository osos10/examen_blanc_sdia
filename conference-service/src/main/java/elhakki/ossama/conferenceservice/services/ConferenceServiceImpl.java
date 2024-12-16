package elhakki.ossama.conferenceservice.services;

import elhakki.ossama.conferenceservice.dtos.ConferenceDTO;
import elhakki.ossama.conferenceservice.entities.Conference;
import elhakki.ossama.conferenceservice.mappers.ConferenceMapper;
import elhakki.ossama.conferenceservice.repositories.ConferenceRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ConferenceServiceImpl implements ConferenceService {

    @Autowired
    private ConferenceRepository conferenceRepository;
    @Override
    public List<ConferenceDTO> getAllConferences() {
        List<Conference> conferences = conferenceRepository.findAll();
        return conferences.stream()
                .map(ConferenceMapper.INSTANCE::conferenceToConferenceDTO)
                .toList();
    }

    @Override
    public Optional<ConferenceDTO> getConferenceById(Long id) {
        return conferenceRepository.findById(String.valueOf(id))
                .map(ConferenceMapper.INSTANCE::conferenceToConferenceDTO);
    }

    @Override
    public ConferenceDTO createConference(ConferenceDTO conferenceDTO) {
        Conference conference = ConferenceMapper.INSTANCE.conferenceDTOToConference(conferenceDTO);
        Conference savedConference = conferenceRepository.save(conference);
        return ConferenceMapper.INSTANCE.conferenceToConferenceDTO(savedConference);
    }

    @Override
    public void deleteConference(Long id) {
        conferenceRepository.deleteById(String.valueOf(id));
    }

    @Override
    public ConferenceDTO updateConference(ConferenceDTO conferenceDTO) {
        return null;
    }
}

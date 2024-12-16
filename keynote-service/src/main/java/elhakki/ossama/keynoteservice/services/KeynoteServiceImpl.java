package elhakki.ossama.keynoteservice.services;

import elhakki.ossama.keynoteservice.dtos.KeynoteDTO;
import elhakki.ossama.keynoteservice.entities.Keynote;
import elhakki.ossama.keynoteservice.mappers.KeynoteMapper;
import elhakki.ossama.keynoteservice.repositories.KeynoteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class KeynoteServiceImpl implements KeynoteService{

    @Autowired
    private KeynoteRepository keynoteRepository;
    @Override
    public List<KeynoteDTO> getAllKeynotes() {
        List<Keynote> keynotes = keynoteRepository.findAll();
        return keynotes.stream()
                .map(KeynoteMapper.INSTANCE::keynoteToKeynoteDTO)
                .toList();
    }

    @Override
    public Optional<KeynoteDTO> getKeynoteById(String id) {
        return keynoteRepository.findById(id)
                .map(KeynoteMapper.INSTANCE::keynoteToKeynoteDTO);
    }

    @Override
    public KeynoteDTO createKeynote(KeynoteDTO keynoteDTO) {
        Keynote keynote = KeynoteMapper.INSTANCE.keynoteDTOToKeynote(keynoteDTO);
        Keynote savedKeynote = keynoteRepository.save(keynote);
        return KeynoteMapper.INSTANCE.keynoteToKeynoteDTO(savedKeynote);
    }

    @Override
    public void deleteKeynote(String id) {
        keynoteRepository.deleteById(id);
    }

    @Override
    public KeynoteDTO updateKeynote(KeynoteDTO keynoteDTO) {
        return null;
    }
}

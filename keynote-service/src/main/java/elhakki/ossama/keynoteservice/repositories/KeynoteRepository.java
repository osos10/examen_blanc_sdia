package elhakki.ossama.keynoteservice.repositories;

import elhakki.ossama.keynoteservice.entities.Keynote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeynoteRepository extends JpaRepository<Keynote, String> {
}
package elhakki.ossama.conferenceservice.repositories;

import elhakki.ossama.conferenceservice.entities.Conference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConferenceRepository extends JpaRepository<Conference, String> {
}
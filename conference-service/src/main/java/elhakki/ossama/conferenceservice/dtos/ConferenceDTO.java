package elhakki.ossama.conferenceservice.dtos;

import elhakki.ossama.conferenceservice.model.Keynote;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ConferenceDTO {
    private Long id;
    private String titre;
    private String type;
    private LocalDate date;
    private int duree;
    private int nombreInscrits;
    private double score;
    private List<Keynote> keynotes;
}
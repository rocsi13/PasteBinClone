package com.example.PasteBinClone;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;
import java.util.Optional;

public interface IPasteService {
    List<Paste> getAllPastes();
    void createPaste (Paste paste);
    void deletePaste (Integer id);
    Optional<Paste> findPaste(Integer id);
}

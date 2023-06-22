package com.example.PasteBinClone;

import java.util.List;
import java.util.Optional;

public interface IPasteService {
    List<Paste> getAllPastes();
    void createPaste (Paste paste);
    void updatePaste(Integer id, Paste paste);
    void deletePaste (Integer id);
    Optional<Paste> findPaste(Integer id);
}

package com.example.PasteBinClone;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PasteService implements IPasteService{
    @Autowired
    private PasteRepository repository;

    @Override
    public List<Paste> getAllPastes(){
        return repository.findAll();
    }
    @Override
    public void createPaste(Paste paste) {
        paste.setPasteDate(LocalDate.now(ZoneId.of("Europe/Bucharest")));
        repository.save(paste);
    }
    @Override
    public void updatePaste(Integer id, Paste paste) {
        Paste existingPaste = repository.getReferenceById(id);
        existingPaste.setContent(paste.getContent());
        existingPaste.setPasteDate(LocalDate.now(ZoneId.of("Europe/Bucharest")));
        repository.save(existingPaste);
    }
    @Override
    public void deletePaste(Integer id) {
        repository.deleteById(id);
    }
    @Override
    public Optional<Paste> findPaste(Integer id) {
        return repository.findById(id);
    }

    public Paste get(Integer id) {
        return repository.getReferenceById(id);
    }
}

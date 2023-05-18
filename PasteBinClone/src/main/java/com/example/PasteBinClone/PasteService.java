package com.example.PasteBinClone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
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
        repository.save(paste);
    }
    @Override
    public void deletePaste(Integer id) {
        repository.deleteById(id);
    }
    @Override
    public Optional<Paste> findPaste(Integer id) {
        return repository.findById(id);
    }
}

package com.example.PasteBinClone;

import jakarta.persistence.criteria.CriteriaBuilder;
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
    public void deletePaste(Integer id) {
        repository.deleteById(id);
    }
    @Override
    public Optional<Paste> findPaste(Integer id) {
        return repository.findById(id);
    }
    @Transactional
    public void editPaste(Integer id, String title, String content) {
        Paste paste = PasteRepository.findPasteById(id)
                .orElseThrow(() -> new IllegalStateException("Paste with id " + id + "does not exists"));
        if (title != null && title.length() > 0 && !Objects.equals(paste.getTitle(), title)) {
            paste.setTitle(title);
        }
        if (content != null && content.length() > 0 && !Objects.equals(paste.getContent(), content)) {
            paste.setContent(content);
        }
        paste.setPasteDate(LocalDate.now(ZoneId.of("Europe/Bucharest")));
    }
    public Paste get(Integer id) throws PasteNotFoundException {
        Optional<Paste> result = repository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new PasteNotFoundException("Could not find any paste with ID " + id);
    }
}

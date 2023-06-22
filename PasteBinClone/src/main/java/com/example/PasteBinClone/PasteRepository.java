package com.example.PasteBinClone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PasteRepository extends JpaRepository<Paste, Integer> {
    static Optional<Paste> findPasteById(Integer id) {
        return null;
    }
}

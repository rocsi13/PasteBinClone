package com.example.PasteBinClone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface PasteRepository extends JpaRepository<Paste, Integer> {
    @Query("SELECT p FROM Paste p WHERE p.id = ?1")
    static Optional<Paste> findPasteById(Integer id) {
        return null;
    }
}

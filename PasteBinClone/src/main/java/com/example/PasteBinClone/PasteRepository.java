package com.example.PasteBinClone;

import org.springframework.data.jpa.repository.JpaRepository;
public interface PasteRepository extends JpaRepository<Paste, Integer> { }

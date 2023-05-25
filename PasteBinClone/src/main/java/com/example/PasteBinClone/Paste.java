package com.example.PasteBinClone;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pasteBin")
public class Paste {
    @Id
    @SequenceGenerator(
            name = "paste_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "paste_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Integer id;
    private String title;
    private String author;
    private String content;
    private LocalDate pasteDate;

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getPasteDate() {
        return pasteDate;
    }

    public void setPasteDate(LocalDate pasteDate) {
        this.pasteDate = pasteDate;
    }

    @Override
    public String toString() {
        return "Paste{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", pasteDate=" + pasteDate +
                '}';
    }

    public Paste() {
    }

    public Paste(Integer id,
                 String title,
                 String author,
                 String content,
                 LocalDate pasteDate) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
        this.pasteDate = pasteDate;
    }
}

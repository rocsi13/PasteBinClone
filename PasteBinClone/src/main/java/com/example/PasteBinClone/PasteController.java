package com.example.PasteBinClone;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PasteController {
    @Autowired
    private PasteService pasteService;

    @GetMapping(path= "/list")
    public String getPastes(Model model) {
        model.addAttribute("paste", pasteService.getAllPastes());
        return "list";
    }
    @GetMapping(path= "/list/add")
    public String add(Model model) {
        Paste paste = new Paste();
        model.addAttribute("paste", paste);
        System.out.println(model);
        return "add";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String savePaste(@ModelAttribute("paste") Paste paste) {
        pasteService.createPaste(paste);
        return "redirect:/list";
    }

    @GetMapping(path = "/delete/{id}")
    public String deletePaste(@PathVariable Integer id) {
        pasteService.deletePaste(id);
        return "redirect:/list";
    }
    @GetMapping(path="/list/edit/{id}")
    public String editPaste(@PathVariable("id")Integer id, Model model, RedirectAttributes ra) {
        try{
            Paste paste = pasteService.get(id);
            model.addAttribute("paste", paste);
            return "edit_form";
        } catch (PasteNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/list";
        }
    }
}
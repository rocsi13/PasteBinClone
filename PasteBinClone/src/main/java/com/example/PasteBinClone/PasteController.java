package com.example.PasteBinClone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PasteController {
    @Autowired
    private PasteService pasteService;

    @GetMapping(path= "/homepage")
    public String getPastes(Model model) {
        model.addAttribute("paste", pasteService.getAllPastes());
        return "homepage";
    }
    @GetMapping(path= "/homepage/add")
    public String add(Model model) {
        Paste paste = new Paste();
        model.addAttribute("paste", paste);
        System.out.println(model);
        return "add";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String savePaste(@ModelAttribute("paste") Paste paste) {
        pasteService.createPaste(paste);
        return "redirect:/homepage";
    }

    @GetMapping(path = "/delete/{id}")
    public String deletePaste(@PathVariable Integer id) {
        pasteService.deletePaste(id);
        return "redirect:/homepage";
    }
    @GetMapping(path = "/edit/{id}")
    public String editPaste(@PathVariable Integer id, Model model) {
        model.addAttribute("paste", pasteService.findPaste(id));
        return "edit";
    }
}

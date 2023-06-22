package com.example.PasteBinClone;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PasteController {
    @Autowired
    private PasteService pasteService;

    @RequestMapping(value= "/pastes", method=RequestMethod.GET)
    public String getPastes(Model model) {
        model.addAttribute("paste", pasteService.getAllPastes());
        return "all-pastes";
    }
    @GetMapping(path= "/pastes/add")
    public String add(Model model) {
        Paste paste = new Paste();
        model.addAttribute("paste", paste);
        System.out.println(model);
        return "add";
    }
    @PostMapping("/save")
    public String savePaste(@ModelAttribute("paste") Paste paste) {
        pasteService.createPaste(paste);
        return "redirect:/pastes";
    }

    @GetMapping(path = "/delete/{id}")
    public String deletePaste(@PathVariable Integer id) {
        pasteService.deletePaste(id);
        return "redirect:/pastes";
    }
    @GetMapping("/update/{id}")
    public String editPaste(@PathVariable(name = "id")Integer id, Model model) throws PasteNotFoundException {
        Paste paste = pasteService.get(id);
        model.addAttribute("paste", paste);
        return "edit-form";
    }
    @PostMapping("/update/{id}")
    public String submitEditForm(@PathVariable Integer id, Paste paste) {
        pasteService.updatePaste(id, paste);
        return "redirect:/pastes";
    }
}
package com.example.gateway1.controller;

import com.example.gateway1.PartService;
import com.example.gateway1.model.part.PartForDisplay;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class PartController {

    private PartService partService;

    @GetMapping("/search")
    public String search(@RequestParam String modelName, Model model) {
        Iterable<PartForDisplay> partsForDisplay = partService.getPartsList(modelName);
        model.addAttribute("model", modelName);
        model.addAttribute("parts", partsForDisplay);
        return "parts-list";
    }

    @GetMapping("/part/{id}")
    public String getPartById(@PathVariable Long id, Model model) {
        PartForDisplay part = partService.getPartById(id);
        Iterable<PartForDisplay> replaces = partService.getReplacesById(id);
        model.addAttribute("part", part);
        model.addAttribute("replaceParts", replaces);
        return "part";
    }
}

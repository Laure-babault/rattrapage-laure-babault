package galerie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import galerie.dao.ExpositionRepository;
import galerie.dto.CaPourExposition;
import galerie.entity.Exposition;
import java.util.List;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Edition des catégories, sans gestion des erreurs
 */
@Controller
@RequestMapping(path = "/exposition")
public class ExpositionController {

    @Autowired
    private ExpositionRepository dao;


    @GetMapping(path = "chiffreAffaire")
    public @ResponseBody
    List<CaPourExposition> listeCA() {
        // This returns a JSON or XML with the categories
        return dao.listeCA();
    }
}

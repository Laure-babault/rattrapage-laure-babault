package galerie.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import galerie.dao.ExpositionRepository;
import galerie.dao.GalerieRepository;
import galerie.dto.CaPourExposition;
import galerie.entity.Exposition;
import galerie.entity.Galerie;
import galerie.entity.Tableau;

/**
 * Edition des catégories, sans gestion des erreurs
 */
@Controller
@RequestMapping(path = "/exposition")
public class ExpositionController {

    private final ExpositionRepository dao;

    public ExpositionController(ExpositionRepository dao) {
        this.dao = dao;
    }

    /**
     * Affiche toutes les expositions dans la base
     * @param model pour transmettre les informations à la vue
     * @return le nom de la vue à afficher ('afficheexpo.html')
     */
    @GetMapping(path = "show")
    public String afficheToutesLesTableaux(Model model) {
        model.addAttribute("Exposition", dao.findAll());
        return "afficheexpo";
    }
    
    /**
     * Montre le formulaire permettant d'ajouter une exposition
     * @param expo initialisé par Spring, valeurs par défaut à afficher dans le formulaire
     * @param model pour transmettre des informations à la vie
     * @return le nom de la vue à afficher ('formulaireExpo.html')
     */
    @GetMapping(path = "add")
    public String montreLeFormulairePourAjout(@ModelAttribute("exposition") Exposition expo, Model model) {
        // Exposition expo = new Exposition();
        // model.addAttribute("expo", expo) ;
        // On transmet la liste des galerie pour pouvoir choisir la galerie de l'exposition
        model.addAttribute("expo", dao.findAll());
        return "formulaireExpo";
    }


    @GetMapping(path = "chiffreAffaire")
    public @ResponseBody
    List<CaPourExposition> listeCA() {
        // This returns a JSON or XML with the categories
        return dao.listeCA();
    }
}

package ma.enset.etudiantmvc.web;

import lombok.AllArgsConstructor;
import ma.enset.etudiantmvc.entities.Etudiant;
import ma.enset.etudiantmvc.entities.Genre;
import ma.enset.etudiantmvc.repositories.EtudiantRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import javax.validation.Valid;

@Controller
@AllArgsConstructor


public class EtudiantController {

    private EtudiantRepository etudiantRepository;

    @GetMapping(path="/user/index")
    public String etudiants(Model model,
                           @RequestParam(name = "page",defaultValue = "0") int page,
                           @RequestParam(name = "size",defaultValue = "5") int size,
                           @RequestParam(name = "keyword",defaultValue = "") String keyword) {
        Page<Etudiant> etudiantsPage=etudiantRepository.findByNomContains(keyword, PageRequest.of(page, size));
        model.addAttribute("listEtudiants",etudiantsPage.getContent());
        model.addAttribute("pages",new int[etudiantsPage.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",keyword);
        return "etudiants";
    }

    @GetMapping(path="/admin/delete")
    public String deleteEtudiant(Model model,@RequestParam(name = "id",defaultValue = "0") Long id,
                                @RequestParam(name = "page",defaultValue = "0") int page,
                                @RequestParam(name = "keyword",defaultValue = "")String keyword) {
        etudiantRepository.deleteById(id);
        return "redirect:/user/index?page="+page+"&keyword="+keyword;
    }
    @GetMapping( "/")
    public String home(){
        return "home";
    }

    @GetMapping(path="/etudiants")
    @ResponseBody
    public List<Etudiant> Etudiants() {
        return etudiantRepository.findAll();
    }

    @GetMapping(path="/admin/formEtudiant")
    public String formEtudiant(Model model) {

        Etudiant e=new Etudiant(null,"test","test","test",new Date(), Genre.FEMININ,false);
        model.addAttribute("etudiant",new Etudiant());
        //model.addAttribute("patient",p);

        return "formEtudiant";
    }


    @PostMapping(path="/amdin/save")
    public String save(Model model, @Valid Etudiant patient, BindingResult bindingResult, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "") String keyword) {

        if(bindingResult.hasErrors()) {
            return "formEtudiant";
        }
        etudiantRepository.save(patient);

        return "redirect:/user/index?page="+page+"&keyword="+keyword;
    }

    @GetMapping(path="/admin/editEtudiant")
    public String editEtudiant(Model model,Long id,int page,String keyword) {
        Etudiant etudiant=etudiantRepository.findById(id).orElse(null);
        if(etudiant==null) {
            throw new RuntimeException("etudiant n'existe pas");
        }
        model.addAttribute("etudiant",etudiant);
        model.addAttribute("page",page);
        model.addAttribute("keyword",keyword);

        return "editEtudiant";
    }


}

package ru.surantaev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.surantaev.entity.Company;
import ru.surantaev.service.CompanyService;

import java.util.List;

@Controller
@RequestMapping("/")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    //Вывод всех компаний
    @GetMapping()
    public String company(Model model) {
        List<Company> getAllCompany = companyService.getAllCompany();
        model.addAttribute("company", getAllCompany);
        return "company/company-page";
    }

    //Ссылка на форму для создании компании
    @GetMapping("/company-create")
    public String creatCompanyForm(Company company) {
        return "company/company-create";
    }

    @PostMapping("/company-create")
    public String createCompany(Company company) {
        companyService.saveCompany(company);
        return "redirect:/";
    }

    //Ссылка на форму для создании компании
    /*--------------------------------------------удаление пользователя---------------------------*/
    @DeleteMapping("/company-delete/{id}")
    public String deleteCompany(@PathVariable("id") Long id) {
        companyService.deleteCompany(id);
        return "redirect:/";
    }

    /*--------------------------------------------обновление пользователя---------------------------*/

    @GetMapping("/company-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model){
        Company company = companyService.getCompanyById(id);
        model.addAttribute("company", company);
        return "company/company-update";
    }

    @PostMapping("/company-update")
    public String updateUser(Company company){
        companyService.saveCompany(company);
        return "redirect:/";
    }
}

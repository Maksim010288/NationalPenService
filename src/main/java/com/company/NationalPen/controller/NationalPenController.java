package com.company.NationalPen.controller;

import com.company.NationalPen.component.DepartmentsNationalPen;
import com.company.NationalPen.component.MachineIdNationalPen;
import com.company.NationalPen.component.MaterialNationalPen;
import com.company.NationalPen.entity.MaterialEntity;
import com.company.NationalPen.service.DbNPService;
import com.company.NationalPen.service.NationalPenService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Data
@RequestMapping("/")
public class NationalPenController {

    private final String url = "redirect:/get/materials";

    @Autowired
    private DbNPService dbNPService;
    private MaterialNationalPen materialNationalPen = new MaterialNationalPen();
    private DepartmentsNationalPen departmentsNationalPen = new DepartmentsNationalPen();
    private MachineIdNationalPen machineId = new MachineIdNationalPen();
    private NationalPenService nationalPenService = new NationalPenService();
    private Model model;


    @GetMapping("get/name")
    public String getNameNP(Model model) {
        model.addAttribute("material", materialNationalPen.getMaterials());
        model.addAttribute("department", departmentsNationalPen.getMaterials());
        model.addAttribute("machineId", machineId.machineId());
        return "homepageNP";
    }

    @PostMapping("add/order")
    public String addMaterial(@RequestParam String departmentNP,
                              @RequestParam String machineId,
                              @RequestParam String paper,
                              @RequestParam String material,
                              @RequestParam Integer quantity) {
        MaterialEntity materialNP = new MaterialEntity(departmentNP, machineId, paper, material, quantity);
        nationalPenService.addMaterial(materialNP);
        dbNPService.addMaterial(materialNP);
        return "redirect:/get/name";
    }

    @GetMapping("get/allMaterial")
    public String getAllMaterial(Model model) {
        model.addAttribute("material", nationalPenService.getMaterials());
        return "addOrder";
    }

    @PostMapping("get/allMaterial")
    public String delMaterial(@RequestParam(defaultValue = "0") Integer id) {
        String url = "redirect:/get/allMaterial";
        return nationalPenService.delMaterial(id, url);
    }

    @GetMapping("get/materials")
    public String getMaterials(Model model) {
        model.addAttribute("materials", dbNPService.viewMaterial());
        return "getOrder";
    }

    @GetMapping("NationalPenService/dataDisplaySystem/get/materials")
    public String getMaterialsBy(Model model) {
        model.addAttribute("materials", dbNPService.viewMaterial());
        return "getOrder";
    }

    @PostMapping("get/materials")
    public String delMaterialById(@RequestParam() Integer idElement) {
        return dbNPService.deleteById(idElement, url);
    }

    @GetMapping("del/allElements")
    public String delAllMaterials() {
        return dbNPService.deleteAll(url);
    }
}
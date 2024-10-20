package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.bindings.ChildInputs;
import com.nt.bindings.DcSummaryReport;
import com.nt.bindings.EducationInputs;
import com.nt.bindings.IncomeInputs;
import com.nt.bindings.PlanSelectionInputs;
import com.nt.services.IDcMgmtService;

@RestController
@RequestMapping("/DataCollection-api")
public class DataCollectionController {
    
    @Autowired
    private IDcMgmtService service;
    
    @PostMapping("/generateCaseNo/{appId}")
    public ResponseEntity<Integer> saveAppidCase(@PathVariable Integer appId) {
        Integer caseNo = service.generateCaseNo(appId);
        return new ResponseEntity<>(caseNo, HttpStatus.OK);       
    }
    
    @GetMapping("/showplanNames")
    public ResponseEntity<List<String>> showPlanNames() {
        List<String> plans = service.showAllPlanNames();
        return new ResponseEntity<>(plans, HttpStatus.OK);
    }
    
    @PostMapping("/savePlan")
    public ResponseEntity<Integer> savePlanSelection(@RequestBody PlanSelectionInputs plan) {
        Integer caseNo = service.savePlanSelection(plan);
        return new ResponseEntity<>(caseNo, HttpStatus.CREATED);
    }
    
    @PostMapping("/saveIncome")
    public ResponseEntity<Integer> saveIncome(@RequestBody IncomeInputs income) {
        Integer caseNo = service.saveIncome(income);
        return new ResponseEntity<>(caseNo, HttpStatus.CREATED);
    }
    
    @PostMapping("/saveEducation")
    public ResponseEntity<Integer> saveEducation(@RequestBody EducationInputs education) {
        Integer caseNo = service.saveEduction(education);  // Corrected method name
        return new ResponseEntity<>(caseNo, HttpStatus.CREATED);
    }
    
    @PostMapping("/saveChild")
    public ResponseEntity<Integer> saveChild(@RequestBody List<ChildInputs> child) {
        Integer caseNo = service.saveChild(child);
        return new ResponseEntity<>(caseNo, HttpStatus.CREATED);
    }
    
    @GetMapping("/showAllData/{caseNo}")
    public ResponseEntity<DcSummaryReport> showAllData(@PathVariable Integer caseNo)
    { 
    	DcSummaryReport report=service.citizenReport(caseNo);
    	return new ResponseEntity<DcSummaryReport>(report,HttpStatus.OK);
    }
}

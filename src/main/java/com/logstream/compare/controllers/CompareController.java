package com.logstream.compare.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.logstream.compare.dtos.NewAndOldVersionRequest;
import com.logstream.compare.services.CompareService;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonStructure;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping(produces = "application/json")
public class CompareController {
    final private CompareService compareService;

    public CompareController(CompareService compareService) {
        this.compareService = compareService;
    }

    @PostMapping("/delta")
    public String get2Jsons(@RequestBody NewAndOldVersionRequest newAndOldVersionRequest) {
        JsonStructure oldVersionReader = Json.createReader(new StringReader(newAndOldVersionRequest.getOldVersion().toString())).readObject();
        JsonStructure newVersionReader = Json.createReader(new StringReader(newAndOldVersionRequest.getNewVersion().toString())).readObject();

        return compareService.compare(oldVersionReader, newVersionReader).toString();
    }
}

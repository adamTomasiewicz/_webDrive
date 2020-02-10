package webDrive.controller;

import webDrive.model.LocalFile;
import webDrive.service.LocalFileService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequestMapping("/api/v1") // podmienilismy tą funkcję w application.properties
@RestController
//https://stackoverflow.com/questions/25242321/difference-between-spring-controller-and-restcontroller-annotation
@CrossOrigin //https://sekurak.pl/czym-jest-cors-cross-origin-resource-sharing-i-jak-wplywa-na-bezpieczenstwo/
public class LocalFileController {

    private LocalFileService localFileService;

    public LocalFileController(LocalFileService localFileService) {
        this.localFileService = localFileService;
    }

    @GetMapping("/files")
    public List<LocalFile> getFiles() {
        return localFileService.getFiles();
    }

    @GetMapping("/files/download/{filename}")
    public ResponseEntity<?> getFile(@PathVariable String filename) {
        return localFileService.getFile(filename);
    }

    @DeleteMapping("/files/delete/{filename}") //todo tu powinien być @DeleteMapping
    public ResponseEntity<?> deleteFile(@PathVariable String filename) {
        return localFileService.deleteFile(filename);
    }

    @PostMapping("/files")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        return localFileService.uploadFile(file);
    }


}


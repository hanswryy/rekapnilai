package com.k4.rekapnilai.controller;

import com.k4.rekapnilai.model.Mahasiswa;
import com.k4.rekapnilai.service.MahasiswaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/mahasiswa")
public class MahasiswaController {

    private final MahasiswaService mahasiswaService;

    public MahasiswaController(MahasiswaService mahasiswaService) {
        this.mahasiswaService = mahasiswaService;
    }

    @PostMapping
    public ResponseEntity addMahasiswa(@RequestBody Mahasiswa mahasiswa) {
        //Method untuk menambahkan mahasiswa
        mahasiswaService.addMahasiswa(mahasiswa);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMahasiswa(@PathVariable String id) {
        //Method untuk menghapus mahasiswa
        mahasiswaService.deleteMahasiswa(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping
    public ResponseEntity updateMahasiswa(@RequestBody Mahasiswa mahasiswa) {
        //Method untuk mengupdate mahasiswa
        mahasiswaService.updateMahasiswa(mahasiswa);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    public ResponseEntity<List<Mahasiswa>> getAllMahasiswa() {
        //Method untuk mengambil semua mahasiswa
        return ResponseEntity.ok(mahasiswaService.getAllMahasiswa());
    }

}

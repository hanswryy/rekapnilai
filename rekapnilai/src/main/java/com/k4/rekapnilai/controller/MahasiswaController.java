package com.k4.rekapnilai.controller;

import com.k4.rekapnilai.model.Mahasiswa;
import com.k4.rekapnilai.service.MahasiswaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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

    public void deleteMahasiswa() {
        //Method untuk menghapus mahasiswa
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

    public void getMahasiswaByName() {
        //Method untuk mengambil mahasiswa berdasarkan nama
    }

}

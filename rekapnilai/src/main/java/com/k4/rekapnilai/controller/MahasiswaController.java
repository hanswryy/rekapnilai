package com.k4.rekapnilai.controller;

import com.k4.rekapnilai.model.Mahasiswa;
import com.k4.rekapnilai.service.MahasiswaService;
import jakarta.persistence.NamedStoredProcedureQuery;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/mahasiswa")
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

//    @DeleteMapping("/{id}")
//    public ResponseEntity deleteMahasiswa(@PathVariable String id) {
//        //Method untuk menghapus mahasiswa
//        mahasiswaService.deleteMahasiswa(id);
//        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//    }

//    @PutMapping
//    public ResponseEntity updateMahasiswa(@RequestBody Mahasiswa mahasiswa) {
//        //Method untuk mengupdate mahasiswa
//        mahasiswaService.updateMahasiswa(mahasiswa);
//        return ResponseEntity.status(HttpStatus.OK).build();
//    }

    @GetMapping
    public ResponseEntity<List<Mahasiswa>> getAllMahasiswa() {
        //Method untuk mengambil semua mahasiswa
        return ResponseEntity.ok(mahasiswaService.getAllMahasiswa());
    }

    @RequestMapping(value = "/home")
    public String home(Model model) {
        model.addAttribute("size", mahasiswaService.getSize());
        return "Home";
    }

    @GetMapping(value = "/listdata")
    public String showAllMahasiswa(Model model) {
        List<Mahasiswa> mahasiswa = mahasiswaService.getAllMahasiswa();
        model.addAttribute("mahasiswa", mahasiswa);
        return "ListMahasiswa";
    }

    @GetMapping(value = "/create")
    public String createMahasiswa(Model model) {
        Mahasiswa mahasiswa = new Mahasiswa();
        model.addAttribute("mahasiswa", mahasiswa);
        return "Create";
    }

    @PostMapping(value = "/create")
    public String submitForm(@ModelAttribute("mahasiswa") Mahasiswa mahasiswa) {
        //Menyimpan mahasiswa ke database
        //Jika nilai akhir lebih dari 100 atau kurang dari 0, maka akan dianggap tidak valid
        //Dengan menggunakan exception handling, kita bisa mengatasi error tersebut
//        try{
//            if(mahasiswa.getNilaiAkhir() > 100 || mahasiswa.getNilaiAkhir() < 0){
//                throw new Exception("Nilai akhir tidak valid ! (Nilai akhir harus 0 - 100)");
//            }
//            mahasiswaService.addMahasiswa(mahasiswa);
//            return "redirect:/mahasiswa/home";
//        }catch (Exception e) {
//            System.out.println(e.getMessage());
//            return "redirect:/mahasiswa/create?error";
//        }
        mahasiswaService.addMahasiswa(mahasiswa);
        return "redirect:/mahasiswa/home";
    }

    @GetMapping(value = "/edit/{id}")
    public String editMahasiswa(@PathVariable (value = "id") String id, Model model) {
        //Mengambil data mahasiswa dari service
        Mahasiswa mahasiswa = mahasiswaService.getMahasiswaById(id);
        //Set data mahasiswa tersebut ke model
        model.addAttribute("mahasiswa", mahasiswa);
        return "Update";
    }
    @PostMapping(value = "/saveMahasiswa")
    public String saveMahasiswa(@ModelAttribute("mahasiswa") Mahasiswa mahasiswa){
        //Menyimpan mahasiswa ke database
        mahasiswaService.saveMahasiswa(mahasiswa);
        return "redirect:/mahasiswa/listdata";
    }


    @GetMapping(value = "/delete/{id}")
    public String deleteMahasiswa(@PathVariable (value = "id") String id) {
        //Menghapus data mahasiswa
        this.mahasiswaService.deleteMahasiswaById(id);
        return "redirect:/mahasiswa/listdata";
    }
}

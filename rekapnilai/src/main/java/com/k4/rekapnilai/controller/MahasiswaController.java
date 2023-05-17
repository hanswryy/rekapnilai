package com.k4.rekapnilai.controller;

import com.k4.rekapnilai.exceptionhandler.BadReqEx;
import com.k4.rekapnilai.exceptionhandler.InvalidNilaiException;
import com.k4.rekapnilai.model.Mahasiswa;
import com.k4.rekapnilai.service.MahasiswaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/mahasiswa")
public class MahasiswaController {

    private final MahasiswaService mahasiswaService;
    
    private String tugasMsg = "";
    private String utsMsg = "";
    private String uasMsg = "";

    public MahasiswaController(MahasiswaService mahasiswaService) {
        this.mahasiswaService = mahasiswaService;
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
    public String submitForm(@ModelAttribute("mahasiswa") Mahasiswa mahasiswa, BindingResult bindingResult, Model model) {
    	try {
    		//Jika nilai akhir lebih dari 100 atau kurang dari 0, maka akan dianggap tidak valid
    		if (mahasiswa.getNilaiTugas() < 0 || mahasiswa.getNilaiTugas() > 100 ||
    				mahasiswa.getNilaiUts() < 0 || mahasiswa.getNilaiUts() > 100 ||
    				mahasiswa.getNilaiUas() < 0 || mahasiswa.getNilaiUas() > 100) {
    			throw new InvalidNilaiException("Masukan tidak valid");
    		}
            if (bindingResult.hasErrors()) {
                throw new BadReqEx("Salah tipe bang");
            }

    		//Menyimpan mahasiswa ke database
            mahasiswaService.addMahasiswa(mahasiswa);
            return "redirect:/mahasiswa/home";
		} catch (InvalidNilaiException e) {
            model.addAttribute("errorMsg", e.getLocalizedMessage());
            return "Create";
        } catch (BadReqEx e) {
            model.addAttribute("badReqMsg", e.getLocalizedMessage());
            return "Create";
        }
    }

    @GetMapping(value = "/edit/{id}")
    public String editMahasiswa(@PathVariable (value = "id") String id, Model model) {
        //Mengambil data mahasiswa dari service
        Mahasiswa mahasiswa = mahasiswaService.getMahasiswaById(id);
        model.addAttribute("mahasiswa", mahasiswa);
        return "Update";
    }
    
    @PostMapping(value = "/saveMahasiswa")
    public String saveMahasiswa(@ModelAttribute("mahasiswa") Mahasiswa mahasiswa, BindingResult bindingResult, Model model) {
    	//validateMahasiswa(mahasiswa);
    	try {
    		if (mahasiswa.getNilaiTugas() < 0 || mahasiswa.getNilaiTugas() > 100 ||
    				mahasiswa.getNilaiUts() < 0 || mahasiswa.getNilaiUts() > 100 ||
    				mahasiswa.getNilaiUas() < 0 || mahasiswa.getNilaiUas() > 100) {
                System.out.println("inv");
    			throw new InvalidNilaiException("Masukan tidak valid");
    		}
            if (bindingResult.hasErrors()) {
                throw new BadReqEx("Salah tipe bang");
            }

    		//Menyimpan mahasiswa ke database
    		mahasiswaService.saveMahasiswa(mahasiswa);
    		return "redirect:/mahasiswa/listdata";
		} catch (InvalidNilaiException e) {
            model.addAttribute("errorMsg", e.getLocalizedMessage());
            return "Update";
        } catch (BadReqEx e) {
            model.addAttribute("badReqMsg", e.getLocalizedMessage());
            return "Update";
        }
    }


    @GetMapping(value = "/delete/{id}")
    public String deleteMahasiswa(@PathVariable (value = "id") String id) {
        //Menghapus data mahasiswa
        this.mahasiswaService.deleteMahasiswaById(id);
        return "redirect:/mahasiswa/listdata";
    }

}

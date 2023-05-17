package com.k4.rekapnilai.service;

import com.k4.rekapnilai.model.Mahasiswa;
import com.k4.rekapnilai.repository.MahasiswaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MahasiswaService {

    private final MahasiswaRepository mahasiswaRepository;

    public MahasiswaService(MahasiswaRepository mahasiswaRepository) {
        this.mahasiswaRepository = mahasiswaRepository;
    }

    public void addMahasiswa(Mahasiswa mahasiswa) {
        mahasiswaRepository.insert(mahasiswa);
    }
    public void saveMahasiswa(Mahasiswa mahasiswa){
        mahasiswaRepository.save(mahasiswa);
    }

    public List<Mahasiswa> getAllMahasiswa() {
        //Method untuk mengambil semua mahasiswa
        return mahasiswaRepository.findAll();
    }

    public Mahasiswa getMahasiswaById(String id) {
        Optional<Mahasiswa> optional = mahasiswaRepository.findById(id);
        Mahasiswa mahasiswa = null;
        if (optional.isPresent()) {
            mahasiswa = optional.get();
        } else {
            throw new RuntimeException("Mahasiswa not found for id :: " + id);
        }
        return mahasiswa;
    }
    public int getSize() {
        return mahasiswaRepository.findAll().size();
    }

    public void deleteMahasiswaById(String id) {
        mahasiswaRepository.deleteById(id);
    }
}

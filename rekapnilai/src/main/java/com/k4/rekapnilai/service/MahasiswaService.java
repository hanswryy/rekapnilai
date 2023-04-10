package com.k4.rekapnilai.service;

import com.k4.rekapnilai.model.Mahasiswa;
import com.k4.rekapnilai.repository.MahasiswaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MahasiswaService {

    private final MahasiswaRepository mahasiswaRepository;

    public MahasiswaService(MahasiswaRepository mahasiswaRepository) {
        this.mahasiswaRepository = mahasiswaRepository;
    }

    public void addMahasiswa(Mahasiswa mahasiswa) {
        //Method untuk menambahkan mahasiswa
        mahasiswaRepository.insert(mahasiswa);
    }

    public void deleteMahasiswa() {
        //Method untuk menghapus mahasiswa
    }

    public void updateMahasiswa(Mahasiswa mahasiswa) {
        //Method untuk mengupdate mahasiswa
        Mahasiswa savedMahasiswa = mahasiswaRepository.findById(mahasiswa.getId())
                .orElseThrow(() -> new RuntimeException(
                        String.format("Mahasiswa dengan id %s tidak ditemukan", mahasiswa.getId())
                ));
        savedMahasiswa.setNamaMhs(mahasiswa.getNamaMhs());
        savedMahasiswa.setNIM(mahasiswa.getNIM());
        savedMahasiswa.setKelas(mahasiswa.getKelas());

        mahasiswaRepository.save(savedMahasiswa);
    }

    public List<Mahasiswa> getAllMahasiswa() {
        //Method untuk mengambil semua mahasiswa
        return mahasiswaRepository.findAll();
    }

    public void getMahasiswaByName() {
        //Method untuk mengambil mahasiswa berdasarkan nama
    }

}
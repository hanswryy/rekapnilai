package com.k4.rekapnilai.repository;

import com.k4.rekapnilai.model.Mahasiswa;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MahasiswaRepository extends MongoRepository<Mahasiswa, String> {
}

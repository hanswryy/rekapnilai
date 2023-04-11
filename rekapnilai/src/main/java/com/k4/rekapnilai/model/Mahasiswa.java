package com.k4.rekapnilai.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("mahasiswa")
public class Mahasiswa{
	@Id
	private String id;
	@Field(name = "nilai_uts")
	private int nilaiUts;
	@Field(name = "nilai_uas")
	private int nilaiUas;
	@Field(name = "nilai_tugas")
	private int nilaiTugas;
	@Field(name = "grade")
	private MhsGrade grade = MhsGrade.getGrade(getNilaiAkhir());
	@Field(name = "nama")
	@Indexed(unique = true)
	private String namaMhs;
	@Field(name = "nim")
	private String NIM;
	@Field(name = "kelas")
	private String kelas;
	@Field(name = "nilai_akhir")
	private double nilaiAkhir = (30*nilaiTugas/100) + (30*nilaiUts/100) + (40*nilaiUas/100);

	public void addMahasiswa(String namaMhs, String NIM, String kelas) {
		this.setNamaMhs(namaMhs);
		this.setNIM(NIM);
		this.setKelas(kelas);
		this.setGrade(MhsGrade.E);
		this.setNilaiUts(0);
		this.setNilaiUas(0);
		this.setNilaiTugas(0);
	}
	
	public int menghitungNilai() {
		int hasilNilai = 0;
		//Menthod menghitung nilai
		return hasilNilai;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getNilaiUts() {
		return nilaiUts;
	}

	public void setNilaiUts(int nilaiUts) {
		this.nilaiUts = nilaiUts;
	}

	public int getNilaiUas() {
		return nilaiUas;
	}

	public void setNilaiUas(int nilaiUas) {
		this.nilaiUas = nilaiUas;
	}

	public int getNilaiTugas() {
		return nilaiTugas;
	}

	public void setNilaiTugas(int nilaiTugas) {
		this.nilaiTugas = nilaiTugas;
	}

	public MhsGrade getGrade() {
		setGrade(MhsGrade.getGrade(getNilaiAkhir()));
		return this.grade;
	}

	public void setGrade(MhsGrade grade) {
		this.grade = grade;
	}

	public String getNamaMhs() {
		return namaMhs;
	}

	public void setNamaMhs(String namaMhs) {
		this.namaMhs = namaMhs;
	}

	public String getNIM() {
		return NIM;
	}

	public void setNIM(String NIM) {
		this.NIM = NIM;
	}

	public String getKelas() {
		return kelas;
	}

	public void setKelas(String kelas) {
		this.kelas = kelas;
	}

	public void setNilaiAkhir(double nilaiAkhir) {
		this.nilaiAkhir = nilaiAkhir;
	}
	
	public double getNilaiAkhir() {
		nilaiAkhir = (30*nilaiTugas/100) + (30*nilaiUts/100) + (40*nilaiUas/100);
		return nilaiAkhir;
	}
}

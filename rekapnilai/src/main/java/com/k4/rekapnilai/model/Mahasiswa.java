package com.k4.rekapnilai.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("mahasiswa")
public class Mahasiswa{
	@Id
	private String id;
	@Field(name = "nilai_jml")
	private int nilaiJml;
	@Field(name = "nilai_uts")
	private int nilaiUts;
	@Field(name = "nilai_uas")
	private int nilaiUas;
	@Field(name = "nilai_tugas")
	private int nilaiTugas;
	@Field(name = "nilai_avr")
	private double nilaiAvr;
	@Field(name = "grade")
	private MhsGrade grade;
	@Field(name = "nama")
	@Indexed(unique = true)
	private String namaMhs;
	@Field(name = "nim")
	private String NIM;
	@Field(name = "kelas")
	private String kelas;

	public void addMahasiswa(String namaMhs, String NIM, String kelas) {
		this.setNamaMhs(namaMhs);
		this.setNIM(NIM);
		this.setKelas(kelas);
		this.setNilaiJml(0);
		this.setNilaiAvr(0);
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

	public int getNilaiJml() {
		return nilaiJml;
	}

	public void setNilaiJml(int nilaiJml) {
		this.nilaiJml = nilaiJml;
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

	public double getNilaiAvr() {
		return nilaiAvr;
	}

	public void setNilaiAvr(double nilaiAvr) {
		this.nilaiAvr = nilaiAvr;
	}

	public MhsGrade getGrade() {
		return grade;
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
}

package com.k4.rekapnilai.model;

public class Mahasiswa{
	private int nilaiJml, nilaiUts, nilaiUas, nilaiTugas;
	private double nilaiAvr;
	private MhsGrade grade;
	private String namaMhs, NIM, kelas;

	public void addMahasiswa(String namaMhs, String NIM, String kelas) {
		this.namaMhs = namaMhs;
		this.NIM = NIM;
		this.kelas = kelas;
		this.nilaiJml = 0;
		this.nilaiAvr = 0;
		this.grade = MhsGrade.E;
		this.nilaiUts = 0;
		this.nilaiUas = 0;
		this.nilaiTugas = 0;
	}
	
	public int menghitungNilai() {
		int hasilNilai = 0;
		//Menthod menghitung nilai
		return hasilNilai;
	}
}

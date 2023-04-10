package com.k4.rekapnilai.model;

public enum MhsGrade {
	A(90),
	AB(85),
	B(80),
	BC(75),
	C(70),
	D(50),
	E(0);
	
	private int minScore;
	
	MhsGrade(int minScore) {
		this.minScore = minScore;
	}
	
	public static MhsGrade getGrade(double score) {
		if (score >= A.minScore) {
			return A;
		} else if (score >= AB.minScore) {
			return AB;
		} else if (score >= B.minScore) {
			return B;
		} else if (score >= BC.minScore) {
			return BC;
		} else if (score >= C.minScore) {
			return C;
		} else if (score >= D.minScore) {
			return D;
		} else {
			return E;
		}
	}
}

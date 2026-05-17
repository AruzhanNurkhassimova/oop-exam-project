package academicBlock;
import java.util.*;
import java.io.Serializable;

public class Mark implements Serializable {
	 private double firstAttestation;
	 private double secondAttestation;
	 private double finalExam;
	 
	 public Mark(double firstAttestation, double secondAttestation, double finalExam) {
		 this.firstAttestation = firstAttestation;
		 this.secondAttestation = secondAttestation;
		 this.finalExam = finalExam;
	 }
	 
	 public double getFirstAttestation() { return firstAttestation; }
	 public double getSecondAttestation() { return secondAttestation; }
	 public double getFinalExam() { return finalExam; }
	 public double getTotal() {}
	 public String getLetterGrade() {}
	 public double getNumericGrade() {}
	 
	 
	 public void setFirstAttestation(double value) {}
	 public void setSecondAttestation(double value) {}
	 public void setFinalExam(double value) {}

	 public boolean isPassed() {}
	}

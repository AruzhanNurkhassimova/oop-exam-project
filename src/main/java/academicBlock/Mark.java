package academicBlock;
import java.io.Serializable;

public class Mark implements Serializable {
	 private static final long serialVersionUID = 1L;
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

	 public void setFirstAttestation(double value) {
		 validate(value);
		 this.firstAttestation = value;
	 }
	 
	 public void setSecondAttestation(double value) {
		 validate(value);
		 this.secondAttestation = value;
	 }
	 
	 public void setFinalExam(double value) {
		 validate(value);
		 this.finalExam = value;
	 }
	 
	 private void validate(double value) {
		 if (value < 0) {
		 throw new IllegalArgumentException("Mark cannot be negative");}
	 }
	 
	 public double getTotal() {
	 return firstAttestation + secondAttestation + finalExam;
	 }
	 public String getLetterGrade() {
		 double total = getTotal();
		 if (total >= 95) return "A";
		 if (total >= 90) return "A-";
		 if (total >= 85) return "B+";
		 if (total >= 80) return "B";
		 if (total >= 75) return "B-";
		 if (total >= 70) return "C+";
		 if (total >= 65) return "C";
		 if (total >= 60) return "C-";
		 if (total >= 55) return "D+";
		 if (total >= 50) return "D";
		 return "F";
	 }
	 
	 public double getNumericGrade() {
		 return switch (getLetterGrade()) {
			 case "A" -> 4.0;
			 case "A-" -> 3.67;
			 case "B+" -> 3.33;
			 case "B" -> 3.0;
			 case "B-" -> 2.67;
			 case "C+" -> 2.33;
			 case "C" -> 2.0;
			 case "C-" -> 1.67;
			 case "D+" -> 1.33;
			 case "D" -> 1.0;
			 default -> 0.0;
			 };
	}
	 
	 public boolean isPassed() {
		 return getTotal() >= 50;
	 }
	 
	 @Override
	 public String toString() {
		 return "Mark{total=" + getTotal() + ", letter='" + getLetterGrade() + "'}";
	 }
}

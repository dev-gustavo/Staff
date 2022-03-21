package CA;

import java.io.File;
import java.util.*;
import java.text.SimpleDateFormat;

public class ReadStaffData {

	public static void main(String[] args) throws Exception{
		//parsing and reading the CSV file data into the film (object) array
		// provide the path here...
        File directory = new File("/Users/gustavomaciel/git/ca_gustavo/CAAlgorithms/bin/CA");
  		String name = directory.getAbsolutePath() + "//Staff.csv";
		Scanner sc = new Scanner(new File(name));
		Staff[] staffs = new Staff[10000];

		// this will just print the header in CSV file
		sc.nextLine();

		int i = 0; String st = "";
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
		while (sc.hasNextLine())  //returns a boolean value
		{
			st = sc.nextLine();
			String[] data = st.split(",");
			staffs[i++] = new Staff(Integer.parseInt(data[0]), data[1], data[2], ft.parse(data[3]), Float.parseFloat(data[4]), ft.parse(data[5]));
		}
		sc.close();  //closes the scanner
				
//		// We can print film details due to overridden toString method in film class
		System.out.println(staffs[0]);
		System.out.println(staffs[1]);
//
//		// we can compare films based on their ID due to overridden CompareTo method in film class
		System.out.println(staffs[0]==staffs[0]);
		System.out.println(staffs[0]==staffs[1]);
	}

}

class Staff implements Comparable<Object>{

	private int empNo;
	private String fName;
	private String sName;
	private Date birthDate;
	private float wage;
	private Date hireDate;

	// constructor
	public Staff(int empNo, String fName, String sName, Date birthDate, float wage, Date hireDate) {
		super();
		this.empNo = empNo;
		this.fName= fName;
		this.sName= sName;
		this.birthDate= birthDate;
		this.wage = wage;
		this.hireDate = hireDate;
	}

	// setters and getters
	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getFName() {
		return fName;
	}

	public void setFName(String fName) {
		this.fName = fName;
	}

	public String getSName() {
		return sName;
	}

	public void setSName(String sName) {
		this.sName = sName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public float getWage(){
		return wage;
	}

	public void setWage(float wage){
		this.wage = wage;
	}
	
		@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + empNo;
		result = prime * result + ((fName == null) ? 0 : fName.hashCode());
		result = prime * result + ((hireDate == null) ? 0 : hireDate.hashCode());
		result = prime * result + ((sName == null) ? 0 : sName.hashCode());
		result = prime * result + Float.floatToIntBits(wage);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Staff other = (Staff) obj;
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (empNo != other.empNo)
			return false;
		if (fName == null) {
			if (other.fName != null)
				return false;
		} else if (!fName.equals(other.fName))
			return false;
		if (hireDate == null) {
			if (other.hireDate != null)
				return false;
		} else if (!hireDate.equals(other.hireDate))
			return false;
		if (sName == null) {
			if (other.sName != null)
				return false;
		} else if (!sName.equals(other.sName))
			return false;
		if (Float.floatToIntBits(wage) != Float.floatToIntBits(other.wage))
			return false;
		return true;
	}

	// so the film objects can be compared when sorting/searching
	// NOTE: this will only allow comparisons based on the title of the film
	@Override
	public int compareTo(Object obj) {
		
	
		/*
		ESSA PARTE QUE PRECISO DE AJUDA //// 
		*/
		
		
		Staff sff = (Staff)obj;
		return empNo - (sff.getEmpNo());
	
	}

	@Override
	public String toString() {
		return ">> Number: " + empNo 
				+ ",Fname: " + fName 
				+ ",Lname: " + sName
				+ ",Bdate: " + birthDate 
				+ ",Wage: " + wage
				+ ",Hdate: " + hireDate + "<<\n";
	}



}

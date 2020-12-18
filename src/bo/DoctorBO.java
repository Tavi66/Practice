package bo;
import java.util.ArrayList;

import dao.DoctorDAO;
import domain.Doctor;

public class DoctorBO {
	private DoctorDAO dao = new DoctorDAO();
	public ArrayList<Doctor> obtainDoctorList() {
		return dao.obtainDoctorList();
	}
	
	public ArrayList<Doctor> searchDoctor(String type,String searchValue) {
		return dao.searchDoctor(type, searchValue);
	}

}

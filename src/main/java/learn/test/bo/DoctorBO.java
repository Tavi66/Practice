package learn.test.bo;
import java.util.ArrayList;
import learn.test.dao.DoctorDAO;
import learn.test.domain.Doctor;

public class DoctorBO {
	private DoctorDAO dao = new DoctorDAO();
	public ArrayList<Doctor> obtainDoctorList() {
		return dao.obtainDoctorList();
	}
	
	public ArrayList<Doctor> searchDoctor(String type,String searchValue) {
		return dao.searchDoctor(type, searchValue);
	}

}

package bo;
import dao.*;
import domain.*;
import java.util.List;


public class ExhibitionBO {
	private ExhibitionDAO dao = new ExhibitionDAO();
	public void insertExhibition(Exhibition exhibition) {
		dao.insert(exhibition);
	}
	public List<Exhibition> listExhibitions(){
		return dao.list();
	}
}

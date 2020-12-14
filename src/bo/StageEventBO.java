package bo;
import dao.*;
import domain.*;
import java.util.List;

public class StageEventBO {
	private StageEventDAO dao = new StageEventDAO();
	public void insertStageEvent(StageEvent stageEvent) {
		dao.insert(stageEvent);
	}
	public List<StageEvent> listStageEvents(){
		return dao.list();
	}
}

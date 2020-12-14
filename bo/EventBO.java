package bo;

import java.util.List;
import dao.EventDAO;
import domain.Event;

public class EventBO {

	private EventDAO dao = new EventDAO();

	public void insert(Event event) {
		dao.insert(event);
	}

	public List<Event> list() {
		return dao.list();
	}

	public Event find(int id) {
		return dao.find(id);
	}
}


package bo;
import java.util.List;
import domain.Sponsor;
import dao.SponsorDAO;

public class SponsorBO {

    private SponsorDAO dao = new SponsorDAO();

    public void insert(Sponsor sponsor) {
        dao.insert(sponsor);
    }

    public List<Sponsor> list() {
        return dao.list();
    }
}


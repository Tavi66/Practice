import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.HashSet;
import java.util.Date;

//import java.util.Set;
//import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import bo.*;
import domain.*;
//import org.hibernate.Session;
//
//import com.mysql.cj.result.StringValueFactory;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException, ParseException {
		Logger log = Logger.getLogger("org.hibernate");
    	log.setLevel(Level.OFF);
    	System.setProperty("org.apache.commons.logging.Log","org.apache.commons.logging.impl.NoOpLog");
    	
    	StageEventBO sebo = new StageEventBO();
    	ExhibitionBO ebo = new ExhibitionBO();
    	List <Exhibition> exhibitionList;
		List <StageEvent> stageEventList;
		
		int id;
		String name;
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		do {
			System.out.println("Menu");
			System.out.println("1.Add exhibition");
			System.out.println("2.Add stage event");
			System.out.println("3.Show exhibitions");
			System.out.println("4.Show stage events");
			System.out.println("5.Exit");
			System.out.println("Enter choice");
			switch(Integer.parseInt(br.readLine())) {
			case 1: //add exhibition
				System.out.println("Enter id");
				id = Integer.parseInt(br.readLine());
				System.out.println("Enter name");
				name=br.readLine();
				System.out.println("Enter no. of stalls");
				int stalls = Integer.parseInt(br.readLine());
				System.out.println("Enter no. occupied");
				int occupied = Integer.parseInt(br.readLine());
				
				Exhibition exhibition = new Exhibition(id, name, stalls, occupied);
				ebo.insertExhibition(exhibition);
				break;
			case 2: //add stageEvent
				System.out.println("Enter id");
				id = Integer.parseInt(br.readLine());
				System.out.println("Enter name");
				name=br.readLine();
				System.out.println("Enter coordinator");
				String coordinator=br.readLine();
				System.out.println("Enter show date");
				String date=br.readLine();
				System.out.println("Enter no. seats available");
				int seatAvailable= Integer.parseInt(br.readLine());
				try {
					Date showDate=sdf.parse(date);
					StageEvent stageEvent = new StageEvent(id, name, coordinator, showDate, seatAvailable);
					sebo.insertStageEvent(stageEvent);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 3: //show exhibition
				exhibitionList = ebo.listExhibitions();
				if(exhibitionList.isEmpty()) {
					System.out.println("Exhibitions not found");
					break;
				}
				System.out.printf("%-15s %-15s %-15s %s\n","Id","Name","No. of stalls","No. occupied");
				for(Exhibition e:exhibitionList) {
					System.out.printf("%-15s %-15s %-15s %s\n",e.getId(),e.getName(),e.getNumberOfStalls(),e.getOccupied());
				}
				break;
			case 4://show stageEvents
				stageEventList = sebo.listStageEvents();
				if(stageEventList.isEmpty()) {
					System.out.println("Stage events not found");
					break;
				}
				System.out.printf("%-15s %-15s %-15s %s\n","Id","Name","Coordinator","Show date","Seats available");
				for(StageEvent s:stageEventList) {
					System.out.printf("%-15s %-15s %-15s %s\n",s.getId(),s.getName(),s.getCoordinator(),sdf.format(s.getShowDate()),s.getSeatAvailable());
				}
				break;
			case 5:
				System.exit(0);
			default:
				System.out.println("Invalid choice");
			}
		}while(true);
		
	}
}

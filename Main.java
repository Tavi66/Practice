import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import bo.*;
import domain.*;


public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		//FILL YOUR CODE
		SponsorBO sbo = new SponsorBO();
		EventBO ebo = new EventBO();
		do {
			System.out.println("Menu");
			System.out.println("1.Add event");
			System.out.println("2.Add sponsor");
			System.out.println("3.Show events");
			System.out.println("4.Show sponsors");
			System.out.println("5.Exit");
			System.out.println("Enter choice");
			switch (Integer.parseInt(br.readLine())) {
				case 1:
					//FILL YOUR CODE
					System.out.println("Enter event id");
					int eid = Integer.parseInt(br.readLine());
					//FILL YOUR CODE
					System.out.println("Enter event name");
					String ename = br.readLine();
					//FILL YOUR CODE
					System.out.println("Enter event detail");
					String detail = br.readLine();
					//FILL YOUR CODE
					ebo.insert(new Event(eid,ename,detail));
					break;
				case 2:
					//FILL YOUR CODE
					System.out.println("Enter sponsor name");
					//FILL YOUR CODE
					String sname = br.readLine();
					System.out.println("Enter sponsor company");
					//FILL YOUR CODE
					String company = br.readLine();
					System.out.println("Enter sponsor amount");
					//FILL YOUR CODE
					double amount = Double.parseDouble(br.readLine());
					System.out.println("Enter event id");
					//FILL YOUR CODE
					int seid = Integer.parseInt(br.readLine());
					Event temp = ebo.find(seid);
					if(temp==null)
					{
						System.out.println("Event not found");
					}else{
						Sponsor s = new Sponsor(sname,company,amount,temp);
						sbo.insert(s);
					}
					break;
				case 3:
					//FILL YOUR CODE
					List<Event> eventList = ebo.list();
					if(eventList.isEmpty())
					{
						System.out.println("Empty List");
					} else{
						System.out.println("Event details");
						System.out.printf("%-15s %-15s %s\n","Id","Name","Detail");

						for(Event e:eventList) {
							System.out.printf("%-15s %-15s %s\n",e.getId(),e.getName(),e.getDetail());
						}}
					break;
				case 4:
					//FILL YOUR CODE
					List<Sponsor> sponsorList = sbo.list();
					if(sponsorList.isEmpty())
					{
						System.out.println("Empty List");
					} else{
						System.out.println("Sponsor details");
						System.out.printf("%-15s %-15s %-15s %-15s %s\n","Id","Name","Company","Amount","Event");
						for(Sponsor s:sponsorList) {
							System.out.printf("%-15s %-15s %-15s %-15s %s\n",s.getId(),s.getName(),s.getCompany(),s.getAmount(),s.getEvent().getName());
						}
					}
					break;
				case 5:
					//FILL YOUR CODE
					return;
				default:
					System.out.println("Invalid choice");
			}
		}while(true);
	}
}

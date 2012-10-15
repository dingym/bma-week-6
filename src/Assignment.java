import java.text.*;
import java.util.*;


public class Assignment {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar toDay = Calendar.getInstance();
		Calendar Dline = Calendar.getInstance();
		Calendar Compdate = Calendar.getInstance();
		Compdate.clear();
		
		Dline.set(Calendar.YEAR, 2012);
		Dline.set(Calendar.MONTH, 10); //November = 10, January = 0
		Dline.set(Calendar.DATE, 2);
		Dline.set(Calendar.HOUR_OF_DAY, 0);
		Dline.set(Calendar.MINUTE, 0);
		Dline.set(Calendar.SECOND, 0);
		Dline.set(Calendar.MILLISECOND, 0);

		
		Task aTask = new Task("Homework", "Do BMA6", "Created", 5l, toDay, Dline, Compdate);
		System.out.println(aTask);
		if(aTask.hasPrerequite())
			System.out.println("The first task has a Prerequisite.\n\n");
		else
			System.out.println("The first task has NO Prerequisite.\n\n");
		if(aTask.isComplete())
			System.out.println("The first task is completed.\n\n");
		else
			System.out.println("The first task has not been completed.\n\n");
		
     	Task aTask2 = new Task();
		System.out.println(aTask2);
		if(aTask2.hasDealine())
			System.out.println("The second task has a Dealine.\n\n");
		else
			System.out.println("The second task has NO Deadline.\n\n");

	} //end of main()
	
	// getElement() has not been used yet
    public static String getElement(String[] values, int index) {
    	if(index >=0 && index<=values.length) {
    		return values[index];
    	} 
    	else {
    	    return null;	
    	}
    } // end of getElement()
} // end of class Assignment

class Task {
	private String Title;
	private String Description;
	private Long Prerequisite;
	private String Status;
	private Calendar CreateDate;
	private Calendar DeadLine;
	private Calendar CompletedDate;
	
	Task(String title, String desc, String status, Long prereq, Calendar crtdate, Calendar Dline, Calendar compdate){
		this.Title = title;
	    this.Description = desc;
	    this.Prerequisite = prereq;
	    this.Status = status;
	    this.CreateDate = crtdate;
		this.DeadLine = Dline;
		this.CompletedDate = compdate;
	}
	
	Task(){
		Calendar toDay = Calendar.getInstance();
		Calendar DDay = Calendar.getInstance();
		DDay.clear();
		Calendar CDay = Calendar.getInstance();
		CDay.clear();
		this.Title = "No title";
	    this.Description = "No description";
	    this.Prerequisite = 0L;
	    this.Status = "No status";
	    this.CreateDate = toDay;
	    this.DeadLine = DDay;
	    this.CompletedDate = CDay;
	 	}
	public Boolean isComplete() {
		if (this.Status == "Completed" )
			return true;
		else
			return false;
	}
	public Calendar getCompletionDate() {
		return this.CompletedDate;
	}
	public String getTitle() {
		return this.Title;
	}
	public String getDescription() {
		return this.Description;
	}
	public Boolean hasPrerequite() {
		if(this.Prerequisite == 0)
			return false;
		else
			return true;
	}
	public Long getPrerequisite(){
		// this needs to return a task which is the prerequisite
		return this.Prerequisite;
	}
	public Boolean hasDealine() {
		Calendar CurrentDate = Calendar.getInstance();
		if (this.DeadLine.before(CurrentDate)) 
			return false;
		else
			return true;
	}
	
	public String toString(){
			return "Task(\nTitle: "+ Title
					+ ". \nDescription: "+Description 
					+ ". \nPreRequisite: "+Prerequisite 
					+ ". \nStatus: "+Status 
					+". \nCreated at: "+new SimpleDateFormat("MM/dd/yyyy").format(CreateDate.getTime())
					+". \nDealine by: "+new SimpleDateFormat("MM/dd/yyyy").format(DeadLine.getTime())
					+". \nComplted at: "+new SimpleDateFormat("MM/dd/yyyy").format(CompletedDate.getTime())
					+"\n)\n";
	}
} //end of Task


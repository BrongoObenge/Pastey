package manager;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class TimeManager {
	public Timestamp getTimestamp(){
		return new Timestamp(Calendar.getInstance().getTime().getTime());
	}
}

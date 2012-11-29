/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package is3calendar;

import calendar_ex.Appointment;
import calendar_ex.CalendarDate;
import calendar_ex.CalendarEx;
import calendar_ex.CalendarTime;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author Chamila Abeyratna
 */
public class Reminder implements ActionListener {
    CalendarEx cal;
    private static CalendarDate startDate;
    private static CalendarDate endDate; 
    
    public Reminder(CalendarEx c) {
        cal = c;
    }
    
  public void actionPerformed(ActionEvent e) {
     GregorianCalendar today = new GregorianCalendar();
     startDate = new CalendarDate(today.get(Calendar.DAY_OF_MONTH)
                ,today.get(Calendar.MONTH)+1,today.get(Calendar.YEAR));
        //endDate = new CalendarDate(monthDays,today.get(Calendar.MONTH)+1,
         //       today.get(Calendar.YEAR));
        
        //get list of appointments between start and end dates
        System.out.println(startDate);
        List<Appointment> apps = cal.getAppointmentsBetweenDates(startDate, startDate);
        CalendarTime currentTime = new CalendarTime(today.get(Calendar.HOUR_OF_DAY), today.get(Calendar.MINUTE));
        System.out.println(currentTime);
        for(Appointment a : apps){
            if (a.reminder > 0 && CalendarTime.GetDuration(currentTime, a.start_time).min < 5) {
                    System.out.println("OK");
            } else {
                    System.out.println("NOPE");
            }
        }
  }
}

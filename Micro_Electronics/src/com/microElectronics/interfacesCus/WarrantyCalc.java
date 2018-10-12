package com.microElectronics.interfacesCus;

import java.sql.Date;

public class WarrantyCalc {
	/*public boolean  calBkoverdue(){

		//get dates from text fields.
		var dueDate = document.getElementById("d1").value;
		var curDate = document.getElementById("d2").value;
		
		//split date to array(date[0] is year,date[1] is month ,date[2] is date)
		dueDate = dueDate.split('-');
		curDate = curDate.split('-');

		//convert array to date object
		dueDate = new Date(dueDate[0],dueDate[1],dueDate[2]);
		curDate = new Date(curDate[0],curDate[1],curDate[2]);

		//get dates in seconds
		dueDateInSec = parseInt(dueDate.getTime()/1000);
		curDateInSec = parseInt(curDate.getTime()/1000);
		var timeDif = 0;
		//calculate the time diffrence
		if(dueDateInSec >= curDateInSec ){
		
			timeDif = dueDateInSec - curDateInSec ;
		}
		else{
			timeDif = curDateInSec - dueDateInSec ;
		}
		//convert time to days
		var dateDif = timeDif/(60*60*24);
		
		var total = dateDif*10;

		alert("Over due by " +dateDif+" days.Total due fee is:"+total);
		
		
	}*/
}

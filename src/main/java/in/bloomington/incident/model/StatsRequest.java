package in.bloomington.incident.model;
/**
 * @copyright Copyright (C) 2014-2015 City of Bloomington, Indiana. All rights reserved.
 * @license http://www.gnu.org/copyleft/gpl.html GNU/GPL, see LICENSE.txt
 * @author W. Sibo <sibow@bloomington.in.gov>
 *
 */

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;


public class StatsRequest implements java.io.Serializable{

    public boolean lastWeek=false, lastMonth=false, lastYear=false;
    String dateFrom = "", dateTo = "";
    String period = "";
    private String type="";
    public StatsRequest(){

    }

    public StatsRequest(boolean lastWeek,
			boolean lastMonth,
			boolean lastYear,
			String dateFrom,
			String dateTo,
			String type,
			String period
			){
	this.lastWeek = lastWeek;
	this.lastMonth = lastMonth;
	this.lastYear = lastYear;
	this.dateFrom = (dateFrom == null)? "":dateFrom;
	this.dateTo = (dateTo == null)? "":dateTo;
	this.type = (type == null) ? "":type;
	this.period = (period == null) ? "":period;
    }

    public boolean getLastWeek() {
	return lastWeek;
    }

    public void setLastWeek(boolean val) {
	if(val)
	    this.lastWeek = val;
    }
    public boolean getLastMonth() {
	return lastMonth;
    }

    public void setLastMonth(boolean val) {
	if(val)
	    this.lastMonth = val;
    }    
    public boolean getLastYear() {
	return lastYear;
    }

    public void setLastYear(boolean val) {
	if(val)
	    this.lastYear = val;
    }
    public String getDateFrom() {
	return dateFrom;
    }

    public void setDateFrom(String val) {
	if(val != null)
	    this.dateFrom = val;
    }
    public String getDateTo() {
	return dateTo;
    }

    public void setDateTo(String val) {
	if(val != null)
	    this.dateTo = val;
    }
    public String getType() {
	return type;
    }

    public void setType(String val) {
	if(val != null)
	    this.type = val;
    }
    public String getPeriod() {
	return period;
    }

    public void setPeriod(String val) {
	if(val != null)
	    this.period = val;
    }
    public void setOptedPeriod(){
	if(period == null || period.isEmpty()){
	    return;
	}
	if(period.indexOf("Week") > -1){
	    lastWeek = true;
	}
	else if(period.indexOf("Month") > -1){
	    lastMonth = true;
	}
	else if(period.indexOf("Year") > -1){
	    lastYear = true;
	}
    }

    public boolean equals(Object obj) { 
          
	if(this == obj) 
	    return true; 
				
        if(obj == null || obj.getClass()!= this.getClass()) 
            return false; 
				
        StatsRequest one = (StatsRequest) obj; 
        return (one.getLastWeek() == this.lastWeek &&
		one.getLastMonth() == this.lastMonth &&
		one.getLastYear() == this.lastYear &&
		one.getType().equals(this.type) &&
		one.getDateFrom().equals(this.dateFrom) &&
		one.getDateTo().equals(this.dateTo));
    }
    @Override
    public int hashCode(){ 
	int ret = 29;
        return ret; 
    }

    @Override
    public String toString() {
	return type;
    } 	
		
}

package in.bloomington.incident.model;
/**
 * @copyright Copyright (C) 2014-2015 City of Bloomington, Indiana. All rights reserved.
 * @license http://www.gnu.org/copyleft/gpl.html GNU/GPL, see LICENSE.txt
 * @author W. Sibo <sibow@bloomington.in.gov>
 *
 */

import java.util.Date;
import java.util.Calendar;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "requests")
public class Request implements java.io.Serializable{

    @Id
    // same as related incident
    private int id;
    private String hash;
    private Character confirmed;
    private Date expires;
    //
		
    public Request(){

    }

    public Request(int id, String hash, Character confirmed, Date expires) {
	super();
	this.id = id;
	this.hash = hash;
	this.confirmed = confirmed;
	this.expires = expires;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getHash() {
	return hash;
    }

    public void setHash(String hash) {
	this.hash = hash;
    }

    public Character getConfirmed() {
	return confirmed;
    }

    public void setConfirmed(Character confirmed) {
	this.confirmed = confirmed;
    }
		
    public boolean isConfirmed() {
	return confirmed != null;
    }
    public Date getExpires() {
	return expires;
    }

    public void setExpires(Date expires) {
	this.expires = expires;
    }
    /**
     * we check expires with current date and time, if it is less
     * than current time then it is expired, else no
     */
    @Transient
    public boolean checkExpired(){
	Date date = new Date() ; // now
	if(expires != null){
	    return date.compareTo(expires) > 0; // after  
	}
	return false;
    }
    // after 3 days max
    @Transient
    public void setExpireDateTime(){
	Calendar cal   = Calendar.getInstance();
	cal.add(Calendar.DAY_OF_MONTH, 3);
        expires = cal.getTime();
    }
    @Override
    public boolean equals(Object obj) { 
          
	if(this == obj) 
	    return true; 
				
        if(obj == null || obj.getClass()!= this.getClass()) 
            return false; 
				
        Request one = (Request) obj; 
        return one.getId() == this.getId();
    }
    @Override
    public int hashCode(){ 
	int ret = 43;
        return ret += this.id; 
    } 	
		
}

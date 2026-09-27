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
import jakarta.persistence.SqlResultSetMapping;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.ColumnResult;
import jakarta.validation.constraints.NotNull;

/**
  // the following moved to Action.class
  // so that hibernate can see it
@SqlResultSetMapping(name="ResultMapping"

*/
public class IncidentStats implements java.io.Serializable{

    public int total=0;
    private String name="";
    public IncidentStats(){

    }

    public IncidentStats(String name, Integer total){
	this.name = (name == null)? "":name;	
	this.total = (total == null)? 0:total;
    }

    public int getTotal() {
	return total;
    }

    public void setTotal(Integer val) {
	if(val != null)
	    this.total = val;
    }

    public String getName() {
	return name;
    }

    public void setName(String val) {
	if(val != null)
	    this.name = name;
    }

    public boolean equals(Object obj) { 
          
	if(this == obj) 
	    return true; 
				
        if(obj == null || obj.getClass()!= this.getClass()) 
            return false; 
				
        IncidentStats one = (IncidentStats) obj; 
        return one.getName() == this.getName();
    }
    @Override
    public int hashCode(){ 
	int ret = 29;
        return ret += this.total; 
    }

    @Override
    public String toString() {
	return name;
    } 	
		
}

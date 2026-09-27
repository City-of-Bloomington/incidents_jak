package in.bloomington.incident.model;
/**
 * @copyright Copyright (C) 2014-2015 City of Bloomington, Indiana. All rights reserved.
 * @license http://www.gnu.org/copyleft/gpl.html GNU/GPL, see LICENSE.txt
 * @author W. Sibo <sibow@bloomington.in.gov>
 *
 */

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
@Table(name = "incident_types")
public class IncidentType implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull(message = "Incident type may not be null")
    private String name;
		@Column(name="used_in_business")
		private Character usedInBusiness;
    //
		
    public IncidentType(){

    }
		
    public IncidentType(int id, @NotNull(message = "Incident type may not be null") String name, Character usedInBusiness) {
				super();
				this.id = id;
				this.name = name;
				this.usedInBusiness = usedInBusiness;
    }

    public int getId() {
				return id;
    }

    public void setId(int id) {
				this.id = id;
    }

    public String getName() {
				return name;
    }

    public void setName(String name) {
				this.name = name;
    }
		public boolean getUsedInBusiness(){
				return usedInBusiness != null;
		}
		public void setUsedInBusiness(boolean val){
				if(val)
						usedInBusiness = 'y';
		}
    @Transient
    public boolean isLostRelated(){
				return name != null && name.indexOf("Lost") > -1;
    }
    @Transient
    public boolean isFraudRelated(){
				return name != null && name.indexOf("Fraud") > -1;
    }		
    @Transient
    public boolean isVandalRelated(){
				return name != null && name.indexOf("Vandal") > -1;
    }		
    @Transient
    public boolean isVehicleRequired(){
				return name != null && name.indexOf("Vehicle") > 0;
    }
    @Override
    public boolean equals(Object obj) { 
          
				if(this == obj) 
						return true; 
				
        if(obj == null || obj.getClass()!= this.getClass()) 
            return false; 
				
        IncidentType one = (IncidentType) obj; 
        return one.getId() == this.getId();
    }
    @Override
    public int hashCode(){ 
				int ret = 29;
        return ret += this.id; 
    }

    @Override
    public String toString() {
				return name;
    } 	
		
}

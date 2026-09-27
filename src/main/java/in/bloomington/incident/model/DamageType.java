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
@Table(name = "damage_types")
public class DamageType implements java.io.Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull(message = "Damage type may not be null")
    private String name;
    private Character inactive;
    //
		
    public DamageType(){

    }
		
    public DamageType(int id, @NotNull(message = "Damage type may not be null") String name, Character inactive) {
				super();
				this.id = id;
				this.name = name;
				this.inactive = inactive;
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
    public Character getInactive() {
				return inactive;
    }
    public void setName(String val) {
				if(val != null)	
						this.name = val;
    }
    public void setInactive(Character val) {
				if(val != null)
						this.inactive = val;
    }
    @Transient
    public boolean isActive(){
				return inactive == null || !Character.isLetter(inactive);
    }
    @Override
    public boolean equals(Object obj) { 
          
				if(this == obj) 
						return true; 
				
        if(obj == null || obj.getClass()!= this.getClass()) 
            return false; 
				
        DamageType one = (DamageType) obj; 
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

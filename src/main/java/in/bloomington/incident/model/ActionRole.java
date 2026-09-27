package in.bloomington.incident.model;
/**
 - @copyright Copyright (C) 2014-2015 City of Bloomington, Indiana. All rights reserved.
 - @license http://www.gnu.org/copyleft/gpl.html GNU/GPL, see LICENSE.txt
 - @author W. Sibo <sibow@bloomington.in.gov>
 -
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
@Table(name = "action_roles")
public class ActionRole implements java.io.Serializable{

		//
		@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
		@NotNull
		@OneToOne			
		Action action;
		@NotNull
		@OneToOne
		Role role;
		
		public ActionRole(){

		}
		
		public ActionRole(int id, Action action, Role role){
				super();
				this.id = id;
				this.action = action;
				this.role = role;
		}

		public int getId() {
				return id;
		}

		public void setId(int id) {
				this.id = id;
		}

		public Action getAction() {
				return action;
		}

		public void setAction(Action action) {
				this.action = action;
		}

		public Role getRole() {
				return role;
		}

		public void setRole(Role role) {
				this.role = role;
		}
		@Override
    public boolean equals(Object obj) { 
          
				if(this == obj) 
						return true; 
				
        if(obj == null || obj.getClass()!= this.getClass()) 
            return false; 
				
        ActionRole one = (ActionRole) obj; 
        return (one.getRole().getId() == this.getRole().getId() &&
								one.getAction().getId() == this.getAction().getId());
		}
		@Override
		public int hashCode(){ 
				int ret = 29;
        return ret += this.getRole().hashCode()+this.getAction().hashCode(); 
    }

		@Override
		public String toString() {
				return this.getAction().toString()+" "+this.getRole().toString();
		} 	
		
}

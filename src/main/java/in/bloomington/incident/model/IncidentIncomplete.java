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


@Entity
@Table(name = "incident_incomplete") // view
public class IncidentIncomplete implements java.io.Serializable{

    @Id
    private int id;

    @OneToOne
    @JoinColumn(name="id",insertable=false, updatable=false)		
    Incident incident;
		
    public IncidentIncomplete(){

    }

    public IncidentIncomplete(int id, Incident val){
	super();
	this.id = id;
	this.incident = val;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }
    public Incident getIncident(){
	return incident;
    }
    public void setIncident(Incident val){
	incident = val;
    }
}

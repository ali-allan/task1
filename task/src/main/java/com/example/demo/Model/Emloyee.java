package com.example.demo.Model;

import javax.persistence.*;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="employees")
public class Emloyee {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long ID;
	 @Column(name="fname")
	private String fname;
	 
	 @Column(name="lname")
    private String lname;
	 
	 @Column(name="dep_id")
    private int dep_id;
	 
	 @Column(name="active")
    private boolean active;
    
	 
	 @ManyToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name = "Departmenr_id",referencedColumnName = "id")
    private Department department;
    
	
	public Emloyee() {
		super();
	}
	public Emloyee(String fname, String lname, int dep_id, boolean active) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.dep_id = dep_id;
		this.active = active;
	}
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getDep_id() {
		return dep_id;
	}
	public void setDep_id(int dep_id) {
		this.dep_id = dep_id;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public Department getDepartment() {
		return department;
	}
	
	@Override
	public String toString() {
		return "Emloyee [ID=" + ID + ", fname=" + fname + ", lname=" + lname + ", dep_id=" + dep_id + ", active="
				+ active + "]";
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emloyee other = (Emloyee) obj;
		if (ID != other.ID)
			return false;
		if (active != other.active)
			return false;
		if (dep_id != other.dep_id)
			return false;
		if (fname == null) {
			if (other.fname != null)
				return false;
		} else if (!fname.equals(other.fname))
			return false;
		if (lname == null) {
			if (other.lname != null)
				return false;
		} else if (!lname.equals(other.lname))
			return false;
		return true;
	}
	public void getDepartment(Department department2) {
		this.department=department2;
		
	}
    
	

}

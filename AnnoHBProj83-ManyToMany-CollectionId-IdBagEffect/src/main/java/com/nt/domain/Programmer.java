package com.nt.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="PROGRAMMERS")
public class Programmer {
	private int pid;
	private String pname;
	private int salary;
	private List<Project> projects=new ArrayList();
	
	@Id
	@GenericGenerator(name="gen1",strategy="increment")
	@GeneratedValue(generator="gen1")
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	
	
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	@ManyToMany(targetEntity=Project.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinTable(name="PROGRAMMERS_PROJECTS",
	           joinColumns=@JoinColumn(name="programmer_id",referencedColumnName="pid"),
	           inverseJoinColumns=@JoinColumn(name="project_id",referencedColumnName="projid"))
	
	@GenericGenerator(name="gen2",strategy="increment")
    @CollectionId(columns=@Column(name="PRGMR_PROJ_INDEX"), generator = "gen2", type = @Type(type="int"))	
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

}

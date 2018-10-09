package com.nt.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="PROGRAMMERS")
public class Programmer {
	private int pid;
	private String pname;
	private int salary;
	private Set<Project> projects=new HashSet();
	
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
	public Set<Project> getProjects() {
		return projects;
	}
	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

}

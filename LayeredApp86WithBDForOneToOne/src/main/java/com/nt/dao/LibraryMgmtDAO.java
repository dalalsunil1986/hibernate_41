package com.nt.dao;

import java.util.List;

import com.nt.domain.Student;

public interface LibraryMgmtDAO {
	public List<Student> getStudentsWithLibraryMembershipDetails();
    public int  deleteStudentWithLibraryLibraryDetails(int sid);
    public  int  insertStudent(Student stud);
}

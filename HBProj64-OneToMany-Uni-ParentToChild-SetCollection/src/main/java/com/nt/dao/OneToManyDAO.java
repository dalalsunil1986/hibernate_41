package com.nt.dao;

public interface OneToManyDAO {
	public void saveDataUsingUserDetails();
	public void loadDataUsingUserDetails();
	public void  deleteOnePhoneNumberFromCollectionOfPhoneNumberBelogingToAUser();
	public void  deleteAllChildsOfAParent();
	public void  deleteUserAndItsChilds();
	public void addNewPhoneNumberToAnExistingUser();
	public void modifyPrivideOfPhoneNumberBelongingToAUser();
    public  void  transferPhoneNumberFromOneUserToAnotherUser();
    //public void ModifyUserIdOfUser(); // not possible
    
}

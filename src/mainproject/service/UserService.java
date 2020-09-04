package mainproject.service;

import java.util.List;

import mainproject.dao.UserDao;
import mainproject.model.DependentProfile;
import mainproject.model.MedicalHistory;
import mainproject.model.UserProfile;

public class UserService {
	private UserDao dao = new UserDao();
	public boolean addUserService(UserProfile user) {
		UserProfile newuser = dao.addUserDao(user);
		if (newuser == null) {
			return false;
		}return true;
	}

	public String verifyUserService(String useremail, String userpassword) {
		UserProfile verifyuser = dao.verifyUserDao(useremail);
		if (verifyuser==null) {
			return "0";
		}
		else if (verifyuser.getPassword().equals(userpassword)) {
			return "1";
		}return "2";
		
	}

	public boolean updateUserInfoService(UserProfile user) {
		UserProfile updateuser = dao.updateUserInfoDao(user);
		if (updateuser==null) {
			return false;
		}return true;
	}

	public UserProfile getUserService(String onlineuseremail) {
		UserProfile getuser = dao.getUserInfoDao(onlineuseremail);
		return getuser;
	}

	public String resetPasswordService(String usermail, String newpwd, String oldpwd) {
		UserProfile upuser = dao.resetPasswordDao(usermail,newpwd,oldpwd);
		System.out.println(upuser);
		if (upuser!=null) {
			return "0";
		}return "1";
		
	}

	public String addDependentService(DependentProfile dependent) {
		DependentProfile newdep = dao.addDependents(dependent.getHeaduserid(),dependent);
		if (newdep!=null) {
			return "0";
		}return "1";
	}

	public String addMedicalHistoryService(MedicalHistory medhistory) {
		boolean res = dao.addMedicalHistory(medhistory, medhistory.getRelation(), medhistory.getUseremail());
		if (res== true) {
			return "1";
		}
		else {
			return "0";
		}
	}
	
	public DependentProfile getDependentService(String onlineuseremail,String relation) {
		DependentProfile getuser = dao.getDependentInfoDao(onlineuseremail,relation);
		return getuser;
	}

	public List<MedicalHistory> getMedicalHistoryService(String onlineuseremail, String relation) {
		List<MedicalHistory> medhist = dao.getMedicalHistoryDao(onlineuseremail,relation);
		return medhist;
	}

	public List<MedicalHistory> getuserMedicalHistoryService(String onlineuseremail) {
		List<MedicalHistory> medhistuser = dao.getuserMedicalHistoryDao(onlineuseremail);
		return medhistuser;
	}



}

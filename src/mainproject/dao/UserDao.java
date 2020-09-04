package mainproject.dao;

import java.util.HashMap;
import java.util.List;

import mainproject.model.DependentProfile;
import mainproject.model.MedicalHistory;
import mainproject.model.UserProfile;

public class UserDao {

	private static HashMap<String, UserProfile> userdata;
	static {
		userdata =  new HashMap<String, UserProfile>();
		UserProfile bot = new UserProfile("bot","bot@gmail.com","india","123456","1-1-1990","bot123");
		UserProfile guest =  new UserProfile("guest","guest@gmail.com","india","00000","1-2-1880","guest123");
		userdata.put(bot.getEmail(), bot);
		userdata.put(guest.getEmail(), guest);
	}
	public UserProfile addUserDao(UserProfile user) {
		UserProfile temp =  userdata.putIfAbsent(user.getEmail(), user);
		return temp;
	}

	public UserProfile verifyUserDao(String useremail) {
		UserProfile result =  userdata.get(useremail);
		return result;
	}

	public UserProfile updateUserInfoDao(UserProfile user) {
		UserProfile result = userdata.put(user.getEmail(), user);
		return result;
	}

	public UserProfile getUserInfoDao(String onlineuseremail) {
		UserProfile mod =  userdata.get(onlineuseremail);
		return mod;
	}

	public UserProfile resetPasswordDao(String usermail, String newpwd, String oldpwd) {
		UserProfile updateuser = userdata.get(usermail);
		//UserProfile olduser = userdata.get(usermail);
		if (updateuser.getPassword()==oldpwd) {	
			updateuser.setPassword(newpwd);
			System.out.println(updateuser);
			return userdata.put(usermail, updateuser);
		}
		else {
			return null;
		}
		
	}
	public DependentProfile addDependents(String useremail, DependentProfile dependent) {
		UserProfile user = userdata.get(useremail);
		DependentProfile dep = user.dependents.put(dependent.getRelationship(), dependent);
		System.out.println(dep);
		return dep;
	}
	
	
	
	public boolean addMedicalHistory(MedicalHistory medhist,String relation,String useremail) {
		if (relation.equalsIgnoreCase("self")) {
			UserProfile headuser = userdata.get(useremail);
			boolean result = headuser.medhistory.add(medhist);
			System.out.println(headuser.medhistory);
			return result;
			
			}
		else {
			System.out.println("This is" + relation);
			UserProfile headuser = userdata.get(useremail);
			DependentProfile depuser = headuser.dependents.get(relation);
			boolean result = depuser.medhistory.add(medhist);
			System.out.println(depuser.medhistory);
			return result;
			
			}
	}

	public DependentProfile getDependentInfoDao(String onlineuseremail, String relation) {
		UserProfile user = userdata.get(onlineuseremail);
		DependentProfile depuser = user.dependents.get(relation);
		return depuser;
	}

	public List<MedicalHistory> getMedicalHistoryDao(String onlineuseremail, String relation) {
		UserProfile user = userdata.get(onlineuseremail);
		DependentProfile depuser = user.dependents.get(relation);
		List<MedicalHistory> medhist = depuser.getMedhistory();
		System.out.println(medhist);
		return medhist;
	}
	
	public List<MedicalHistory> getuserMedicalHistoryDao(String onlineuseremail) {
		UserProfile user = userdata.get(onlineuseremail);
		List<MedicalHistory> medhist = user.getMedhistory();
		System.out.println(medhist);
		return medhist;
	}	
}
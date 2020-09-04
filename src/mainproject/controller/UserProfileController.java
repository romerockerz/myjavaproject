package mainproject.controller;


import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import mainproject.model.DependentProfile;
import mainproject.model.MedicalHistory;
import mainproject.model.UserProfile;
import mainproject.service.UserService;

@Path("userprofile")
public class UserProfileController {
	private UserService service  =  new UserService();
	@POST
	@Path("adduser")
	public String addUser(@BeanParam UserProfile user) {
		System.out.println(user);
		boolean result = service.addUserService(user);
		if (result) {
			return "true";
		}return "false";
	}
	@POST
    @Path("verifyuser")
	public String verifyUser(@FormParam("useremail") String useremail, @FormParam("userpwd") String userpassword) {
		String res = service.verifyUserService(useremail,userpassword);
		return res;
	}
	
	@GET
	@Path("getuser/{useremail}")
	@Produces(MediaType.APPLICATION_JSON)
	public UserProfile getUserInfo(@PathParam("useremail") String onlineuseremail) {
		UserProfile getuserinfo = service.getUserService(onlineuseremail);
		System.out.println(getuserinfo);
		return getuserinfo;
	}
	
	@PUT
	@Path("updateuser")
	public String updateUser(@BeanParam UserProfile user) {
		boolean updateuser = service.updateUserInfoService(user);
		if(updateuser== false) {
			return "0";
		}return "1";
	}
	
	@PUT
	@Path("resetpassword")
	public String newPassword(@FormParam("useremail") String usermail, @FormParam("newpwd") String newpwd,
			@FormParam("oldpwd") String oldpwd) {
		String updatepwd = service.resetPasswordService(usermail,newpwd,oldpwd); 
		if (updatepwd=="1") {
			return "1";
		}return "0";
	}
	
	@POST
	@Path("adddependent")
	public String newDependent(@BeanParam DependentProfile dependent) {
		String newdep = service.addDependentService(dependent);
		if (newdep=="1") {
			return "1";
		}return "0";
	}
	
	@POST
	@Path("addmedhistory")
	public String newMedHistory(@BeanParam MedicalHistory medhistory) {
		System.out.println(medhistory);
		String newdep = service.addMedicalHistoryService(medhistory);
		if (newdep=="1") {
			return "1";
		}return "0";
	}
	
	@GET
	@Path("getdependent")
	@Produces(MediaType.APPLICATION_JSON)
	public DependentProfile getDependentInfo(@QueryParam("useremail") String onlineuseremail, 
			@QueryParam("relation") String relation) {
		DependentProfile getdepinfo = service.getDependentService(onlineuseremail,relation);
		System.out.println(getdepinfo);
		if (getdepinfo!=null) {
			return getdepinfo;}
		else {
			return null;
		}
	}
	@GET
	@Path("getmedhistory")
	@Produces(MediaType.APPLICATION_JSON)
	public List<MedicalHistory> getMedicalHitoryInfo(@QueryParam("useremail") String onlineuseremail, 
			@QueryParam("relation") String relation) {		
			List <MedicalHistory> meddep = service.getMedicalHistoryService(onlineuseremail,relation);
			System.out.println("controller" + meddep);
			return meddep;
			
	}
	@GET
	@Path("getusermedhistory")
	@Produces(MediaType.APPLICATION_JSON)
	public List<MedicalHistory> getuserMedicalHitoryInfo(@QueryParam("useremail") String onlineuseremail) {	
			List <MedicalHistory> meduser= service.getuserMedicalHistoryService(onlineuseremail);
			System.out.println("controlleruser"+meduser);
			return meduser;
			
}
}	
	

package com.mjee.app.holder;

import com.mjee.app.domain.Admin;

public class AdminHolder {
	
	private static ThreadLocal<Admin> USER_HOLDER = new ThreadLocal<Admin>();
	
	public static Admin getCurrentAdmin() {
		return USER_HOLDER.get();
	}
	
	public static void setCurrentAdmin(Admin admin) {
		USER_HOLDER.set(admin);
	}
	
	public static void removeCurrentAdmin() {
		USER_HOLDER.remove();
	}
	
}

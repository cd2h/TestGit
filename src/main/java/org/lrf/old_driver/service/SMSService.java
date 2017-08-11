package org.lrf.old_driver.service;

public interface SMSService {
	public void sendMessage(String cellPhone);

	public boolean checkVirtfyCode(String virtfyCode);
}

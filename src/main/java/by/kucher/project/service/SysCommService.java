package by.kucher.project.service;

import java.util.List;

public interface SysCommService {

	public List<Object[]> dailyResDeploy();

	public List<Object[]> dailyResDestroy();

	public List<Object[]> dailyLinkCreate();

	public List<Object[]> dailyLinkDestroy();

	public List<Object[]> dailyFieldCreate();

	public List<Object[]> dailyPortalCapture();

}

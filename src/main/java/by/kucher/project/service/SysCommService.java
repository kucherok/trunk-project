package by.kucher.project.service;

import java.util.List;

public interface SysCommService {

	public List<Object[]> dailyResDeploy(Integer msgtsStart, Integer msgtsFinish);

	public List<Object[]> dailyResDestroy(Integer msgtsStart, Integer msgtsFinish);

	public List<Object[]> dailyLinkCreate(Integer msgtsStart, Integer msgtsFinish);

	public List<Object[]> dailyLinkDestroy(Integer msgtsStart, Integer msgtsFinish);

	public List<Object[]> dailyFieldCreate(Integer msgtsStart, Integer msgtsFinish);

	public List<Object[]> dailyFieldDestroy(Integer msgtsStart, Integer msgtsFinish);

	public List<Object[]> dailyPortalCapture(Integer msgtsStart, Integer msgtsFinish);

}

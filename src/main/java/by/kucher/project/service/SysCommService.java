package by.kucher.project.service;

import java.util.List;

public interface SysCommService {

	public List<Object[]> dailyResDeploy(Long msgtsStart, Long msgtsFinish);

	public List<Object[]> dailyResDestroy(Long msgtsStart, Long msgtsFinish);

	public List<Object[]> dailyLinkCreate(Long msgtsStart, Long msgtsFinish);

	public List<Object[]> dailyLinkDestroy(Long msgtsStart, Long msgtsFinish);

	public List<Object[]> dailyFieldCreate(Long msgtsStart, Long msgtsFinish);

	public List<Object[]> dailyFieldDestroy(Long msgtsStart, Long msgtsFinish);

	public List<Object[]> dailyPortalCapture(Long msgtsStart, Long msgtsFinish);

}

package by.kucher.project.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import by.kucher.project.repositories.SysCommRepository;

@Service
public class SysCommServiceImpl implements SysCommService {

	@Resource
	private SysCommRepository sysCommRepository;

	@Override
	public List<Object[]> dailyResDeploy(Integer msgtsStart, Integer msgtsFinish) {
		return sysCommRepository.dailyActivity(msgtsStart, msgtsFinish, "resdeploy");
	}

	@Override
	public List<Object[]> dailyResDestroy(Integer msgtsStart, Integer msgtsFinish) {
		return sysCommRepository.dailyActivity(msgtsStart, msgtsFinish, "resdestroy");
	}

	@Override
	public List<Object[]> dailyLinkCreate(Integer msgtsStart, Integer msgtsFinish) {
		return sysCommRepository.dailyActivity(msgtsStart, msgtsFinish, "linkcreate");
	}

	@Override
	public List<Object[]> dailyLinkDestroy(Integer msgtsStart, Integer msgtsFinish) {
		return sysCommRepository.dailyActivity(msgtsStart, msgtsFinish, "linkdestroy");
	}

	@Override
	public List<Object[]> dailyFieldCreate(Integer msgtsStart, Integer msgtsFinish) {
		return sysCommRepository.dailyActivity(msgtsStart, msgtsFinish, "fieldcreate");
	}

	@Override
	public List<Object[]> dailyFieldDestroy(Integer msgtsStart, Integer msgtsFinish) {
		return sysCommRepository.dailyActivity(msgtsStart, msgtsFinish, "fielddestroy");
	}

	@Override
	public List<Object[]> dailyPortalCapture(Integer msgtsStart, Integer msgtsFinish) {
		return sysCommRepository.dailyActivity(msgtsStart, msgtsFinish, "portalcapture");
	}

}

package by.kucher.project.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import by.kucher.project.repositories.SysCommRepository;

@Service
public class SysCommServiceImpl implements SysCommService {

	@Resource
	private SysCommRepository sysCommRepository;

	Integer msgts = 1407963511;

	@Override
	public List<Object[]> dailyResDeploy() {
		return sysCommRepository.dailyActivity(msgts, "resdeploy");
	}

	@Override
	public List<Object[]> dailyResDestroy() {
		return sysCommRepository.dailyActivity(msgts, "resdestroy");
	}

	@Override
	public List<Object[]> dailyLinkCreate() {
		return sysCommRepository.dailyActivity(msgts, "linkcreate");
	}

	@Override
	public List<Object[]> dailyLinkDestroy() {
		return sysCommRepository.dailyActivity(msgts, "linkdestroy");
	}

	@Override
	public List<Object[]> dailyFieldCreate() {
		return sysCommRepository.dailyActivity(msgts, "fieldcreate");
	}

	@Override
	public List<Object[]> dailyPortalCapture() {
		return sysCommRepository.dailyActivity(msgts, "portalcapture");
	}

}

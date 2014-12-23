package by.kucher.project.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.kucher.project.model.Portal;
import by.kucher.project.repositories.PortalRepository;

@Service
public class PortalServiceImpl implements PortalService {

	@Resource
	private PortalRepository portalRepository;

	@Override
	@Transactional
	public Portal create(Portal portal) {
		Portal createPortal = portal;
		return portalRepository.save(createPortal);
	}

	@Override
	public Portal delete(Portal portal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<Portal> findAll() {
		return portalRepository.findAll();
	}

	@Override
	public Portal update(Portal portal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Portal findById(Portal portal) {
		// TODO Auto-generated method stub
		return null;
	}

}

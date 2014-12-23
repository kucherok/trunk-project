package by.kucher.project.service;

import java.util.List;

import by.kucher.project.model.Portal;

public interface PortalService {

	public Portal create(Portal portal);

	public Portal delete(Portal portal);

	public List<Portal> findAll();

	public Portal update(Portal portal);

	public Portal findById(Portal portal);

}

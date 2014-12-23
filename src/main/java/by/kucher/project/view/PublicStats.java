package by.kucher.project.view;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ru.xpoft.vaadin.VaadinView;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Panel;

@Component
@Scope("prototype")
@VaadinView(PublicStats.NAME)
public class PublicStats extends Panel implements View {

	private static final long serialVersionUID = -385016021277100929L;

	public static final String NAME = "publicStats";
	
	@PostConstruct
	public void PostConstruct() {
		
		setSizeFull();
		
	}

	@Override
	public void enter(ViewChangeEvent event) {

	}

}

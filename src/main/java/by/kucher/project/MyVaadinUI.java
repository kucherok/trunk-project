package by.kucher.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ru.xpoft.vaadin.DiscoveryNavigator;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

@Component
@Scope("prototype")
@Theme("valo")
public class MyVaadinUI extends UI {

	private static final long serialVersionUID = -100421719943256132L;

	@Autowired
	private transient ApplicationContext applicationContext;

	@SuppressWarnings("unused")
	@Override
	protected void init(VaadinRequest request) {

		setSizeFull();

		DiscoveryNavigator navigator = new DiscoveryNavigator(this, this);

	}

}

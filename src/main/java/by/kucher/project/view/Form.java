package by.kucher.project.view;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@Component
@Scope("prototype")
public class Form extends VerticalLayout {

	@PostConstruct
	public void PostConstruct() {

		Label label = new Label("Form");
		addComponent(label);

	}

}

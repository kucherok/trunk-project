package by.kucher.project.view;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ru.xpoft.vaadin.VaadinView;
import by.kucher.project.service.PortalService;
import by.kucher.project.view.leftmenu.SelectableMenu;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Link;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

@Component
@Scope("prototype")
@VaadinView(MainView.NAME)
public class MainView extends Panel implements View {

	private static final long serialVersionUID = 7001087735937820071L;

	public static final String NAME = "";

	@Autowired
	private PortalService portalService;

	@PostConstruct
	public void PostConstruct() {

		setSizeFull();

		final VerticalLayout layout = new VerticalLayout();
		layout.setSpacing(true);
		layout.setMargin(true);

		final HorizontalSplitPanel horizontalSplitPanel = new HorizontalSplitPanel();
		horizontalSplitPanel.setSizeFull();
		horizontalSplitPanel.setSplitPosition(30, Unit.PERCENTAGE);

		VerticalLayout v = new VerticalLayout();

		// Tree tree = new Tree();
		// tree.setContainerDataSource(SelectableMenu.getHardwareContainer());
		// tree.setImmediate(true);
		// tree.setItemCaptionPropertyId(SelectableMenu.hw_PROPERTY_NAME);
		// tree.setItemCaptionMode(ItemCaptionMode.PROPERTY);
		// v.addComponent(tree);
		v.addComponent(new SelectableMenu());
		v.addComponent(new Link("Go to the Label View", new ExternalResource("#!" + PublicStats.NAME)));

		horizontalSplitPanel.setFirstComponent(v);

		horizontalSplitPanel.setSecondComponent(new Button("Show info about application project",
				new Button.ClickListener() {

					private static final long serialVersionUID = -3551897285936555070L;

					public void buttonClick(ClickEvent event) {

					}
				}));

		layout.addComponent(horizontalSplitPanel);
		setContent(layout);
	}

	@Override
	public void enter(ViewChangeEvent event) {
	}

}

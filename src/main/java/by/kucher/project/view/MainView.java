package by.kucher.project.view;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ru.xpoft.vaadin.VaadinView;
import by.kucher.project.model.Guid;
import by.kucher.project.service.PortalService;
import by.kucher.project.service.SysCommService;
import by.kucher.project.view.leftmenu.SelectableMenu;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
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

	@Autowired
	private SysCommService sysCommService;

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

		horizontalSplitPanel.setFirstComponent(v);

		horizontalSplitPanel.setSecondComponent(new Button("Show info about application project",
				new Button.ClickListener() {

					private static final long serialVersionUID = -3551897285936555070L;

					public void buttonClick(ClickEvent event) {
						horizontalSplitPanel.setSecondComponent(new Label("click ===> " + new Date()));

						List<Object[]> obj = sysCommService.dailyResDeploy();
						for (int i = 0; i < obj.size(); i++) {
							Object[] o = obj.get(i);
							// String g = (String) o[0];
							Guid g = (Guid) o[0];
							Long integer = (Long) o[1];
							layout.addComponent(new Label(g.getNickname() + " <===> " + integer));
							// layout.addComponent(new Label(o[0] + " = " +
							// o[1]));
						}

						// List<Portal> list = portalService.findAll();
						// for (int i = 0; i < 10; i++) {
						// Portal p = list.get(i);
						// layout.addComponent(new Label(p.getPortalgid() +
						// " ===>"
						// + String.valueOf(p.getLat()) + " - " +
						// String.valueOf(p.getLon())
						// + " --- " + p.getPortaladdr().getPortaladdr() + ">>>"
						// + p.getPortaladdr().getPortaltitle()));
						// }
					}
				}));

		layout.addComponent(horizontalSplitPanel);
		setContent(layout);
	}

	@Override
	public void enter(ViewChangeEvent event) {
	}

}

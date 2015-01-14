package by.kucher.project.view;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ru.xpoft.vaadin.VaadinView;
import by.kucher.project.model.Guid;
import by.kucher.project.service.SysCommService;

import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.datefield.Resolution;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

@Component
@Scope("prototype")
@VaadinView(PublicStats.NAME)
public class PublicStats extends Panel implements View {

	private static final long serialVersionUID = -385016021277100929L;

	public static final String NAME = "publicStats";

	@Autowired
	private SysCommService sysCommService;

	private static final Long MSGTSSTART = (long) 1407953511;
	private static final Long MSGTSFINISH = (long) 1407963511;

	private static final String NICKNAME = "nickname";
	private static final String AMOUNT = "amount";

	private Table tableResDeploy = new Table("Resonators deployed 24h");
	private Table tableResDestroy = new Table("Resonators destroy 24h");
	private Table tableLinkCreate = new Table("Create Links 24h");
	private Table tableLinkDestroy = new Table("Destroy Links 24h");
	private Table tableFieldCreate = new Table("Create field 24h");
	private Table tableFieldDestroy = new Table("Field Destroy 24h");
	private Table tablePortalCapture = new Table("Portal Capture 24h");

	@PostConstruct
	public void PostConstruct() {

		setSizeFull();

		final VerticalLayout vlGlobalLayout = new VerticalLayout();
		vlGlobalLayout.setImmediate(true);
		vlGlobalLayout.setSpacing(true);

		final HorizontalLayout hlFilter = new HorizontalLayout();
		hlFilter.setImmediate(true);
		hlFilter.setSpacing(true);

		final PopupDateField globalStartDateFilter = new PopupDateField();
		final PopupDateField globalFinishDateFilter = new PopupDateField();
		globalStartDateFilter.setImmediate(true);
		globalFinishDateFilter.setImmediate(true);
		globalStartDateFilter.setTimeZone(TimeZone.getTimeZone("GMT+3"));
		globalFinishDateFilter.setTimeZone(TimeZone.getTimeZone("GMT+3"));
		globalStartDateFilter.setResolution(Resolution.MINUTE);
		globalFinishDateFilter.setResolution(Resolution.MINUTE);
		globalStartDateFilter.setDateFormat("yyyy-MM-dd hh:mm");
		globalFinishDateFilter.setDateFormat("yyyy-MM-dd hh:mm");

		// backup DB
		globalStartDateFilter.setValue(new Date(MSGTSSTART * 1000));
		globalFinishDateFilter.setValue(new Date(MSGTSFINISH * 1000));

		// production
		// globalStartDateFilter.setValue(minusDays(new Date(), -1));
		// globalFinishDateFilter.setValue(new Date());

		hlFilter.addComponent(globalStartDateFilter);
		hlFilter.addComponent(globalFinishDateFilter);

		final Button bFilter = new Button("filter", FontAwesome.REFRESH);
		bFilter.setImmediate(true);
		bFilter.addClickListener(new ClickListener() {

			private static final long serialVersionUID = -3445242859848270038L;

			@Override
			public void buttonClick(ClickEvent event) {
				Notification.show("run filter", Type.WARNING_MESSAGE);
				buildContainerDataSource(globalStartDateFilter.getValue().getTime() / 1000,
						globalFinishDateFilter.getValue().getTime() / 1000);
			}
		});
		hlFilter.addComponent(bFilter);

		vlGlobalLayout.addComponent(hlFilter);

		final HorizontalLayout hlPublicStats = new HorizontalLayout();
		hlPublicStats.setSizeFull();
		hlPublicStats.setImmediate(true);
		hlPublicStats.setSpacing(true);

		tableResDeploy.setImmediate(true);
		tableResDestroy.setImmediate(true);
		tableLinkCreate.setImmediate(true);
		tableLinkDestroy.setImmediate(true);
		tableFieldCreate.setImmediate(true);
		tableFieldDestroy.setImmediate(true);
		tablePortalCapture.setImmediate(true);

		hlPublicStats.addComponent(tableResDeploy);
		hlPublicStats.addComponent(tableResDestroy);
		hlPublicStats.addComponent(tableLinkCreate);
		hlPublicStats.addComponent(tableLinkDestroy);
		hlPublicStats.addComponent(tableFieldCreate);
		hlPublicStats.addComponent(tableFieldDestroy);
		hlPublicStats.addComponent(tablePortalCapture);

		buildContainerDataSource(MSGTSSTART, MSGTSFINISH);

		vlGlobalLayout.addComponent(hlPublicStats);
		setContent(vlGlobalLayout);

	}

	private void buildContainerDataSource(long startDateFilter, long finishDateFilter) {

		tableResDeploy.setContainerDataSource(buildContainer(sysCommService.dailyResDeploy(startDateFilter,
				finishDateFilter)));
		tableResDestroy.setContainerDataSource(buildContainer(sysCommService.dailyResDestroy(startDateFilter,
				finishDateFilter)));
		tableLinkCreate.setContainerDataSource(buildContainer(sysCommService.dailyLinkCreate(startDateFilter,
				finishDateFilter)));
		tableLinkDestroy.setContainerDataSource(buildContainer(sysCommService.dailyLinkDestroy(
				startDateFilter, finishDateFilter)));
		tableFieldCreate.setContainerDataSource(buildContainer(sysCommService.dailyFieldCreate(
				startDateFilter, finishDateFilter)));
		tableFieldDestroy.setContainerDataSource(buildContainer(sysCommService.dailyFieldDestroy(
				startDateFilter, finishDateFilter)));
		tablePortalCapture.setContainerDataSource(buildContainer(sysCommService.dailyPortalCapture(
				startDateFilter, finishDateFilter)));

	}

	@SuppressWarnings("unchecked")
	private IndexedContainer buildContainer(List<Object[]> resultData) {

		IndexedContainer container = new IndexedContainer();

		container.addContainerProperty("nickname", String.class, null);
		container.addContainerProperty("amount", Long.class, null);

		for (int i = 0; i < resultData.size(); i++) {
			Object[] o = resultData.get(i);
			Guid name = (Guid) o[0];
			Long amount = (Long) o[1];
			Item addItem = container.getItem(container.addItem());
			addItem.getItemProperty(NICKNAME).setValue(name.getNickname());
			addItem.getItemProperty(AMOUNT).setValue(amount);
		}

		return container;
	}

	private Date minusDays(Date date, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days); // minus number would decrement the days
		return cal.getTime();
	}

	@Override
	public void enter(ViewChangeEvent event) {

	}

}

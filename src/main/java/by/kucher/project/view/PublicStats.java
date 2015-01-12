package by.kucher.project.view;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.ui.datefield.Resolution;
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

	private static final Integer MSGTSSTART = 1407953511;
	private static final Integer MSGTSFINISH = 1407963511;

	private static final String NICKNAME = "nickname";
	private static final String AMOUNT = "amount";

	@PostConstruct
	public void PostConstruct() {

		setSizeFull();

		final VerticalLayout vlGlobalFilter = new VerticalLayout();
		// vlGlobalFilter.setSizeFull();
		vlGlobalFilter.setImmediate(true);
		vlGlobalFilter.setSpacing(true);

		final PopupDateField globalDateFilter = new PopupDateField("Enter date", new Date());
		globalDateFilter.setImmediate(true);
		globalDateFilter.setTimeZone(TimeZone.getTimeZone("GMT+3"));
		globalDateFilter.setResolution(Resolution.MINUTE);
		globalDateFilter.setDateFormat("yyyy-MM-dd hh:mm");
		vlGlobalFilter.addComponent(globalDateFilter);

		globalDateFilter.addValueChangeListener(new ValueChangeListener() {

			private static final long serialVersionUID = -1070411712937785285L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
				// dateFormat.parse(dateFormat.format(event.getProperty().getValue()));

				Date d = (Date) event.getProperty().getValue();

				Timestamp t = new Timestamp(1407963511);
				Date dd = new Date(t.getTime()*1000);

				Notification.show("date to integer = ", String.valueOf(d.getTime()), Type.ERROR_MESSAGE);
				System.out.println(String.valueOf(d.getTime()/1000));
				System.out.println(dd);
				System.out.println(dateFormat.format(dd));
				// System.out.println("1407963511");
				// System.out.println(new Date(d.getTime()));
				// System.out.println(new Date(1407963511));
			}
		});

		final HorizontalLayout hlPublicStats = new HorizontalLayout();
		hlPublicStats.setSizeFull();
		hlPublicStats.setImmediate(true);
		hlPublicStats.setSpacing(true);

		final Table tableResDeploy = new Table("Resonators deployed 24h");
		tableResDeploy.setImmediate(true);
		List<Object[]> listResultResDeploy = sysCommService.dailyResDeploy(MSGTSSTART, MSGTSFINISH);
		tableResDeploy.setContainerDataSource(buildContainer(listResultResDeploy));
		hlPublicStats.addComponent(tableResDeploy);

		final Table tableResDestroy = new Table("Resonators destroy 24h");
		tableResDestroy.setImmediate(true);
		List<Object[]> listResultResDestroy = sysCommService.dailyResDestroy(MSGTSSTART, MSGTSFINISH);
		tableResDestroy.setContainerDataSource(buildContainer(listResultResDestroy));
		hlPublicStats.addComponent(tableResDestroy);

		final Table tableLinkCreate = new Table("Create Links 24h");
		tableLinkCreate.setImmediate(true);
		List<Object[]> listResultLinkCreate = sysCommService.dailyLinkCreate(MSGTSSTART, MSGTSFINISH);
		tableLinkCreate.setContainerDataSource(buildContainer(listResultLinkCreate));
		hlPublicStats.addComponent(tableLinkCreate);

		final Table tableLinkDestroy = new Table("Destroy Links 24h");
		tableLinkDestroy.setImmediate(true);
		List<Object[]> listResultLinkDestroy = sysCommService.dailyLinkDestroy(MSGTSSTART, MSGTSFINISH);
		tableLinkDestroy.setContainerDataSource(buildContainer(listResultLinkDestroy));
		hlPublicStats.addComponent(tableLinkDestroy);

		final Table tableFieldCreate = new Table("Create field 24h");
		tableFieldCreate.setImmediate(true);
		List<Object[]> listResultFieldCreate = sysCommService.dailyFieldCreate(MSGTSSTART, MSGTSFINISH);
		tableFieldCreate.setContainerDataSource(buildContainer(listResultFieldCreate));
		hlPublicStats.addComponent(tableFieldCreate);

		final Table tableFieldDestroy = new Table("Field Destroy 24h");
		tableFieldDestroy.setImmediate(true);
		List<Object[]> listResultFieldDestroy = sysCommService.dailyFieldDestroy(MSGTSSTART, MSGTSFINISH);
		tableFieldDestroy.setContainerDataSource(buildContainer(listResultFieldDestroy));
		hlPublicStats.addComponent(tableFieldDestroy);

		final Table tablePortalCapture = new Table("Portal Capture 24h");
		tablePortalCapture.setImmediate(true);
		List<Object[]> listResultFieldCapture = sysCommService.dailyPortalCapture(MSGTSSTART, MSGTSFINISH);
		tablePortalCapture.setContainerDataSource(buildContainer(listResultFieldCapture));
		hlPublicStats.addComponent(tablePortalCapture);

		vlGlobalFilter.addComponent(hlPublicStats);
		setContent(vlGlobalFilter);

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

	@Override
	public void enter(ViewChangeEvent event) {

	}

}

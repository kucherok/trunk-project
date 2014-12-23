package by.kucher.project.view.leftmenu;

import by.kucher.project.view.PublicStats;

import com.vaadin.data.Item;
import com.vaadin.data.util.HierarchicalContainer;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Page;
import com.vaadin.ui.AbstractSelect.ItemCaptionMode;
import com.vaadin.ui.Accordion;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Tree;
import com.vaadin.ui.VerticalLayout;

public class SelectableMenu extends Accordion implements ItemClickListener {

	private static final long serialVersionUID = -1240215915919361078L;

	public static final Object hw_PROPERTY_NAME = "name";
	private static final String[][] STATISTICS = { { "Публичная статистика", "Суточная активность",
			"comming soon ...", "...", "..." } };
	private static final String[][] CHARTS = { { "Инфографика", "Инфографика Минск", "comming soon ..." } };
	private static final String[][] MAPS = { { "Общие карты", "Карта всех порталов РБ",
			"Подробная карта Минска", "Глобал by,ua,pl,lt,lv,ee,cz,sk-09.06.2014" } };
	private static final String[][] PERSONALMAPS = { { "Личные карты", "kucherblr", "...", "..." } };

	public SelectableMenu() {

		setSizeFull();

		final VerticalLayout layoutItemsStatistic = new VerticalLayout();
		layoutItemsStatistic.setMargin(true);
		final Tree treeStatistic = new Tree();
		treeStatistic.setSizeFull();
		treeStatistic.setContainerDataSource(getHierarchicalContainer(STATISTICS));
		treeStatistic.setImmediate(true);
		treeStatistic.setItemCaptionPropertyId(hw_PROPERTY_NAME);
		treeStatistic.setItemCaptionMode(ItemCaptionMode.PROPERTY);
		for (final Object id : treeStatistic.rootItemIds()) {
			treeStatistic.expandItemsRecursively(id);
		}
		treeStatistic.addItemClickListener(this);
		layoutItemsStatistic.addComponent(treeStatistic);

		final VerticalLayout layoutItemsCharts = new VerticalLayout();
		layoutItemsStatistic.setMargin(true);
		final Tree treeCharts = new Tree();
		treeCharts.setSizeFull();
		treeCharts.setContainerDataSource(getHierarchicalContainer(CHARTS));
		treeCharts.setImmediate(true);
		treeCharts.setItemCaptionPropertyId(hw_PROPERTY_NAME);
		treeCharts.setItemCaptionMode(ItemCaptionMode.PROPERTY);
		for (final Object id : treeCharts.rootItemIds()) {
			treeCharts.expandItemsRecursively(id);
		}
		layoutItemsCharts.addComponent(treeCharts);

		final VerticalLayout layoutItemsMaps = new VerticalLayout();
		layoutItemsStatistic.setMargin(true);
		final Tree treeMaps = new Tree();
		treeMaps.setSizeFull();
		treeMaps.setContainerDataSource(getHierarchicalContainer(MAPS));
		treeMaps.setImmediate(true);
		treeMaps.setItemCaptionPropertyId(hw_PROPERTY_NAME);
		treeMaps.setItemCaptionMode(ItemCaptionMode.PROPERTY);
		for (final Object id : treeMaps.rootItemIds()) {
			treeMaps.expandItemsRecursively(id);
		}
		layoutItemsMaps.addComponent(treeMaps);

		final VerticalLayout layoutItemsPersonalMaps = new VerticalLayout();
		layoutItemsStatistic.setMargin(true);
		Tree treePersonalMaps = new Tree();
		treePersonalMaps.setSizeFull();
		treePersonalMaps.setContainerDataSource(getHierarchicalContainer(PERSONALMAPS));
		treePersonalMaps.setImmediate(true);
		treePersonalMaps.setItemCaptionPropertyId(hw_PROPERTY_NAME);
		treePersonalMaps.setItemCaptionMode(ItemCaptionMode.PROPERTY);
		for (final Object id : treePersonalMaps.rootItemIds()) {
			treePersonalMaps.expandItemsRecursively(id);
		}
		layoutItemsPersonalMaps.addComponent(treePersonalMaps);

		addTab(layoutItemsStatistic, "Статистика", FontAwesome.GROUP);
		addTab(layoutItemsCharts, "Графики", FontAwesome.BAR_CHART_O);
		addTab(layoutItemsMaps, "Карты", FontAwesome.MAP_MARKER);
		addTab(layoutItemsPersonalMaps, "Личные карты", FontAwesome.MAP_MARKER);
	}

	@SuppressWarnings("unchecked")
	public static HierarchicalContainer getHierarchicalContainer(String[][] arrayItems) {
		Item item = null;
		int itemId = 0; // Increasing numbering for itemId:s

		// Create new container
		HierarchicalContainer hwContainer = new HierarchicalContainer();
		// Create containerproperty for name
		hwContainer.addContainerProperty(hw_PROPERTY_NAME, String.class, null);
		for (int i = 0; i < arrayItems.length; i++) {
			// Add new item
			item = hwContainer.addItem(itemId);
			// Add name property for item
			item.getItemProperty(hw_PROPERTY_NAME).setValue(arrayItems[i][0]);
			// Allow children
			hwContainer.setChildrenAllowed(itemId, true);
			itemId++;
			for (int j = 1; j < arrayItems[i].length; j++) {
				// Add child items
				item = hwContainer.addItem(itemId);
				item.getItemProperty(hw_PROPERTY_NAME).setValue(arrayItems[i][j]);
				hwContainer.setParent(itemId, itemId - j);
				hwContainer.setChildrenAllowed(itemId, false);
				itemId++;
			}
		}
		return hwContainer;
	}

	@Override
	public void itemClick(ItemClickEvent event) {
		Notification.show(event.getItem().toString() + "=========" + event.getItemId().toString());
		Page.getCurrent().setUriFragment("!" + PublicStats.NAME);

	}

}

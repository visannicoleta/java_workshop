package com.example.demo;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;

@SpringUI
public class MainPage extends UI {

	@Override
	protected void init(VaadinRequest request) {

		VerticalLayout layout = new VerticalLayout();

		TextField cnpTF = new TextField("CNP:");
		Button btn = new Button("Valideaza");
		layout.addComponent(cnpTF);
		layout.addComponent(btn);

		VerticalLayout content = new VerticalLayout();
		Label popupLabel = new Label("This is a popup");
		TextField popupText = new TextField("Click to edit");
		Button popupBtn = new Button("Click me");

		content.addComponent(popupLabel);
		content.addComponent(popupText);
		content.addComponent(popupBtn);
		
		PopupView popupView = new PopupView(null, content);
		Button openPopup = new Button("Open popup", click -> {
			popupView.setPopupVisible(true);
		});
		
		layout.addComponent(openPopup);
		layout.addComponent(popupView);

		setContent(layout);

		btn.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				String cnp = cnpTF.getValue(); // "2930813340441";

				CNPValidator validator = new CNPValidator(cnp);
				if (validator.isCNPValid()) {
					Notification.show("CNP is valid !");
				} else {
					Notification.show("CNP is not valid !");
				}
			}
		});

	}

}

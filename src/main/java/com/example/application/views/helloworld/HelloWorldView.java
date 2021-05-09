package com.example.application.views.helloworld;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.example.application.components.CustomDateTimePicker;
import com.example.application.components.MyComponentField;
import com.example.application.views.main.MainView;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Span;

@Route(value = "hello", layout = MainView.class)
//@RouteAlias(value = "", layout = MainView.class)
@PageTitle("Hello World | Vaadin Training")
@CssImport("./views/helloworld/hello-world-view.css")
public class HelloWorldView extends VerticalLayout {

    private TextField name;
    private Button sayHello;
    private MyComponentField myComponent;
    
    public HelloWorldView() {
        /*addClassName("hello-world-view");
        name = new TextField("Your name");
        sayHello = new Button("Say hello");
        add(name, sayHello);
        setVerticalComponentAlignment(Alignment.END, name, sayHello);
        sayHello.addClickListener(e -> {
            Notification.show("Hello " + name.getValue());
        });*/
    	
    	TextField textField = new TextField();

    	// Simple HTML inline text
    	Span greeting = new Span("Hello ...");

    	textField.addValueChangeListener(event ->
    	      greeting.setText("Hello " + event.getValue()));
       	
    	VerticalLayout layout = new VerticalLayout(
    	      textField, greeting);
    	
    	myComponent = new MyComponentField("Hello ...");
    	
    	CustomDateTimePicker customDateTimePicker = new CustomDateTimePicker();
    	
    	add(layout, myComponent, customDateTimePicker);
    }

}

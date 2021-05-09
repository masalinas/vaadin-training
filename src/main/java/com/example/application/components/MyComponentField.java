package com.example.application.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

@Tag("my-component")
@CssImport("components/my-component.css")
public class MyComponentField extends Component implements HasComponents {
	private VerticalLayout layout = new VerticalLayout();
	private TextField textField;
	private Span greeting;
	
	// initial value field
	public MyComponentField(String message) {
		textField = new TextField();
		greeting = new Span(message);
		
	 	textField.addValueChangeListener(event ->
	      greeting.setText("Hello " + event.getValue()));
	 	
		layout.add(textField, greeting);
		
		add(layout);
    }
}

package com.example.application.views.training;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.checkbox.CheckboxGroupVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import com.github.appreciated.prism.element.Language;
import com.github.appreciated.prism.element.PrismHighlighter;

import com.example.application.backend.mocks.Department;
import com.example.application.views.main.MainView;

@SuppressWarnings("serial")
@PageTitle("Training: Checkbox Form input")
@Route(value = "checkbox", layout = MainView.class)
public class TrainingView extends VerticalLayout {
	 public TrainingView() {
		 setSizeFull();
		 setPadding(true);
		 
		 // Basic Usage		 
		 add(getCheckBoxBasicUsage());
		 
		 // Basic usage with checkbox group
		 add(getCheckBoxBasicWithCheckboxGroup());
		 
		 // Disable state
		 add(getDisabledState());
		 
		 // Entity List
		 add(getEntitylist());
		 
		 // Value Change Event
		 add(getValueChangeEvent());
		 
		 // Indeterminate Checkbox
		 add(getIndeterminateCheckbox());
		 
		 // Help Test and Components
		 add(getHelpTestComponent());
	 }
	 
	 private Component getCheckBoxBasicUsage() {
		 // Code Components
		 PrismHighlighter javaCode = new PrismHighlighter(
				    "Checkbox checkbox = new Checkbox();\n" +	                
			                "checkbox.setLabel(\"Option\");\n" +
			                "checkbox.setValue(true);\n" +
			                "add(checkbox);",
			                Language.java);
		 
		 Checkbox checkbox = new Checkbox();
		 checkbox.setLabel("Option");
		 checkbox.setValue(true);
 
		 // Code Layout
		 VerticalLayout codeLayout = new VerticalLayout();
		 codeLayout.setVisible(false);
		 codeLayout.getElement().getStyle().set("background-color", "white");
		 
		 codeLayout.add(javaCode);
		 
		 Button btnShowCode = new Button("Show Code", new Icon(VaadinIcon.ARROW_DOWN));
		 btnShowCode.getElement().getStyle().set("margin-left", "auto");
		 btnShowCode.addClickListener(event -> {
			 if (codeLayout.isVisible()) {
				 codeLayout.setVisible(false);
				 btnShowCode.setIcon(new Icon(VaadinIcon.ARROW_DOWN));
			 }
			 else {
				 codeLayout.setVisible(true);
				 btnShowCode.setIcon(new Icon(VaadinIcon.ARROW_UP));
			 }
	     });
		 
		 // Main Layout
		 VerticalLayout mainLayout = new VerticalLayout();
		 
		 mainLayout.add(new H1("Basic usage"));		 
		 mainLayout.add(checkbox);
		 mainLayout.add(btnShowCode);		 
		 mainLayout.add(codeLayout);
		 mainLayout.add(new Hr());
		 
		 return mainLayout;
	 }
	 
	 private Component getCheckBoxBasicWithCheckboxGroup() {
		 // Code Components
		 PrismHighlighter javaCode = new PrismHighlighter(
				    "CheckboxGroup<String> checkboxGroup = new CheckboxGroup<>();\n" +	                
	                "checkboxGroup.setLabel(\"Label\");\n" +
	                "checkboxGroup.setValue(Collections.singleton(\"Option one\"));\n" +
	                "checkboxGroup.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);\n" +
	                "add(checkboxGroup);",
	                Language.java);		 
		 
		 CheckboxGroup<String> checkboxGroup = new CheckboxGroup<>();
		 checkboxGroup.setLabel("Label");
		 checkboxGroup.setItems("Option one", "Option two", "Option three");
		 checkboxGroup.setValue(Collections.singleton("Option one"));
		 checkboxGroup.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);
		 add(checkboxGroup);
	 
	     // Code Layout
		 VerticalLayout codeLayout = new VerticalLayout(); 
		 codeLayout.setVisible(false);
		 codeLayout.getElement().getStyle().set("background-color", "white");
		 
		 codeLayout.add(javaCode);
		 
		 Button btnShowCode = new Button("Show Code", new Icon(VaadinIcon.ARROW_DOWN));
		 btnShowCode.getElement().getStyle().set("margin-left", "auto");
		 btnShowCode.addClickListener(event -> {
			 if (codeLayout.isVisible()) {
				 codeLayout.setVisible(false);
				 btnShowCode.setIcon(new Icon(VaadinIcon.ARROW_DOWN));
			 }
			 else {
				 codeLayout.setVisible(true);
				 btnShowCode.setIcon(new Icon(VaadinIcon.ARROW_UP));
			 }
	     });
		 
		 // Main Layout
		 VerticalLayout mainLayout = new VerticalLayout();
		 
		 mainLayout.add(new H1("Basic usage with checkbox group"));		 
		 mainLayout.add(checkboxGroup);
		 mainLayout.add(btnShowCode);		 
		 mainLayout.add(codeLayout);
		 mainLayout.add(new Hr());
		 
		 return mainLayout;
	 }	 	

	 private Component getDisabledState() {
		 // Code Components
		 PrismHighlighter javaCode = new PrismHighlighter(
				    "CheckboxGroup<String> disabledCheckGroup = new CheckboxGroup<>();\n" +	                
	                "disabledCheckGroup.setLabel(\"Disabled\");\n" +
	                "disabledCheckGroup.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);\n" +
	                "disabledCheckGroup.setValue(Collections.singleton(\"Option one\"));\n" +
	                "disabledCheckGroup.setEnabled(false);\n" +
	                "" +
	                "CheckboxGroup<String> checkboxGroup = new CheckboxGroup<>();\n" +
	                "checkboxGroup.setLabel(\"Disabled item\");\n" +
	                "checkboxGroup.setItems(\"Option one\", \"Option two\", \"Option three\");\n" +
	                "checkboxGroup.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);\n" +
	                "checkboxGroup.setItemEnabledProvider(item -> !\"Option three\".equals(item));\n" +
	                "add(disabledCheckGroup, checkboxGroup);",	                
	                Language.java);		 
		 
		 CheckboxGroup<String> disabledCheckGroup = new CheckboxGroup<>();
		 disabledCheckGroup.setLabel("Disabled");
		 disabledCheckGroup.setItems("Option one", "Option two", "Option three");
		 disabledCheckGroup.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);
		 disabledCheckGroup.setValue(Collections.singleton("Option one"));
		 disabledCheckGroup.setEnabled(false);

		 CheckboxGroup<String> checkboxGroup = new CheckboxGroup<>();
		 checkboxGroup.setLabel("Disabled item");
		 checkboxGroup.setItems("Option one", "Option two", "Option three");
		 checkboxGroup.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);
		 checkboxGroup
		         .setItemEnabledProvider(item -> !"Option three".equals(item));
		 add(disabledCheckGroup, checkboxGroup);
	 
	     // Code Layout
		 VerticalLayout codeLayout = new VerticalLayout(); 
		 codeLayout.setVisible(false);
		 codeLayout.getElement().getStyle().set("background-color", "white");
		 
		 codeLayout.add(javaCode);
		 
		 Button btnShowCode = new Button("Show Code", new Icon(VaadinIcon.ARROW_DOWN));
		 btnShowCode.getElement().getStyle().set("margin-left", "auto");
		 btnShowCode.addClickListener(event -> {
			 if (codeLayout.isVisible()) {
				 codeLayout.setVisible(false);
				 btnShowCode.setIcon(new Icon(VaadinIcon.ARROW_DOWN));
			 }
			 else {
				 codeLayout.setVisible(true);
				 btnShowCode.setIcon(new Icon(VaadinIcon.ARROW_UP));
			 }
	     });
		 
		 // Main Layout
		 VerticalLayout mainLayout = new VerticalLayout();
		 
		 mainLayout.add(new H1("Disabled state"));		 
		 mainLayout.add(disabledCheckGroup, checkboxGroup);		 
		 mainLayout.add(btnShowCode);		 
		 mainLayout.add(codeLayout);
		 mainLayout.add(new Hr());
		 
		 return mainLayout;
	 }	
	 
	 private Component getEntitylist() {
		 // Code Components
		 PrismHighlighter javaCode = new PrismHighlighter(
				    "CheckboxGroup<Department> checkboxGroup = new CheckboxGroup<>();\n" +	                
	                "checkboxGroup.setLabel(\"Department\");\n" +
	                "List<Department> departmentList = getDepartments();\n" +
	                "checkboxGroup.setItems(departmentList);\n" +
	                "checkboxGroup.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);\n" +
	                "add(checkboxGroup);",	                
	                Language.java);		 
		 
		 CheckboxGroup<Department> checkboxGroup = new CheckboxGroup<>();
		 checkboxGroup.setLabel("Department");
		 List<Department> departmentList = Department.getDepartments();
		 checkboxGroup.setItems(departmentList);
		 checkboxGroup.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);
		 add(checkboxGroup);
	 
	     // Code Layout
		 VerticalLayout codeLayout = new VerticalLayout(); 
		 codeLayout.setVisible(false);
		 codeLayout.getElement().getStyle().set("background-color", "white");
		 
		 codeLayout.add(javaCode);
		 
		 Button btnShowCode = new Button("Show Code", new Icon(VaadinIcon.ARROW_DOWN));
		 btnShowCode.getElement().getStyle().set("margin-left", "auto");
		 btnShowCode.addClickListener(event -> {
			 if (codeLayout.isVisible()) {
				 codeLayout.setVisible(false);
				 btnShowCode.setIcon(new Icon(VaadinIcon.ARROW_DOWN));
			 }
			 else {
				 codeLayout.setVisible(true);
				 btnShowCode.setIcon(new Icon(VaadinIcon.ARROW_UP));
			 }
	     });
		 
		 // Main Layout
		 VerticalLayout mainLayout = new VerticalLayout();
		 
		 mainLayout.add(new H1("Entity list"));		 
		 mainLayout.add(checkboxGroup);
		 mainLayout.add(btnShowCode);		 
		 mainLayout.add(codeLayout);
		 mainLayout.add(new Hr());
		 
		 return mainLayout;
	 }
	 
	 private Component getValueChangeEvent() {
		 // Code Components
		 PrismHighlighter javaCode = new PrismHighlighter(
				    "CheckboxGroup<String> checkboxGroup = new CheckboxGroup<>();\n" +	                
	                "checkboxGroup.setLabel(\"Label\");\n" +
	                "checkboxGroup.setItems(\"Option one\", \"Option two\", \"Option three\");\n" +
	                "checkboxGroup.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);\n" +
	                "" +
	                "Div value = new Div();\n" +
	                "value.setText(\"Select a value\");\n" +
	                "checkboxGroup.addValueChangeListener(event -> {\n" +
	                "  if (event.getValue() == null) {\n" +
	                "    value.setText(\"No option selected\");\n" +
	                "  } else {\n" +
	                "    value.setText(\"Selected: \" + event.getValue());\n" +
	                "  }\n" +
	                "});",
	                Language.java);		 
		 
		 CheckboxGroup<String> checkboxGroup = new CheckboxGroup<>();
		 checkboxGroup.setLabel("Label");
		 checkboxGroup.setItems("Option one", "Option two", "Option three");
		 checkboxGroup.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);

		 Div value = new Div();
		 value.setText("Select a value");
		 checkboxGroup.addValueChangeListener(event -> {
		     if (event.getValue() == null) {
		         value.setText("No option selected");
		     } else {
		         value.setText("Selected: " + event.getValue());
		     }
		 });
		 add(checkboxGroup, value);
	 
	     // Code Layout
		 VerticalLayout codeLayout = new VerticalLayout(); 
		 codeLayout.setVisible(false);
		 codeLayout.getElement().getStyle().set("background-color", "white");
		 
		 codeLayout.add(javaCode);
		 
		 Button btnShowCode = new Button("Show Code", new Icon(VaadinIcon.ARROW_DOWN));
		 btnShowCode.getElement().getStyle().set("margin-left", "auto");
		 btnShowCode.addClickListener(event -> {
			 if (codeLayout.isVisible()) {
				 codeLayout.setVisible(false);
				 btnShowCode.setIcon(new Icon(VaadinIcon.ARROW_DOWN));
			 }
			 else {
				 codeLayout.setVisible(true);
				 btnShowCode.setIcon(new Icon(VaadinIcon.ARROW_UP));
			 }
	     });
		 
		 // Main Layout
		 VerticalLayout mainLayout = new VerticalLayout();
		 
		 mainLayout.add(new H1("Value change event"));		 
		 mainLayout.add(checkboxGroup, value);
		 mainLayout.add(btnShowCode);		 
		 mainLayout.add(codeLayout);
		 mainLayout.add(new Hr());
		 
		 return mainLayout;
	 }
	 
	 private Component getIndeterminateCheckbox() {
		 // Code Component Text
		 PrismHighlighter javaCode = new PrismHighlighter(
				    "Checkbox checkbox = new Checkbox(\"Select all\");\n" +	                
	                "CheckboxGroup<String> checkboxGroup = new CheckboxGroup<>();\n" +
	                "Set<String> items = new LinkedHashSet<>(Arrays.asList(\"Option one\", \"Option two\"));\n" +
	                "checkboxGroup.setItems(items);\n" +
	                "checkboxGroup.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);" +
	                "checkboxGroup.addValueChangeListener(event -> {\n" +
	                "  if (event.getValue().size() == items.size()) {\n" +
	                "    checkbox.setValue(true);\n" +
	                "    checkbox.setIndeterminate(false);\n" +
	                "  } else if (event.getValue().size() == 0) {\n" +
	                "    checkbox.setValue(false);\n" +
	                "    checkbox.setIndeterminate(false);\n" +
	                "  } else\n" +
	                "    checkbox.setIndeterminate(true);\n" +
	                "});\n" +
	                "" +
	                "checkbox.addValueChangeListener(event -> {\n" +
	                "  if (checkbox.getValue()) {\n" +
	                "    checkboxGroup.setValue(items);\n" +
	                "  } else {\n" +
	                "    checkboxGroup.deselectAll();\n" +
	                "}\n" +
	                "" +
	                "checkboxGroup.setValue(Collections.singleton(\"Option one\"));\n" +
	                "add(checkbox, checkboxGroup);",	                
	                Language.java);		 
		 
		 // Code Components Test
		 Checkbox checkbox = new Checkbox("Select all");
		 CheckboxGroup<String> checkboxGroup = new CheckboxGroup<>();
		 Set<String> items = new LinkedHashSet<>(
		         Arrays.asList("Option one", "Option two"));
		 checkboxGroup.setItems(items);
		 checkboxGroup.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);
		 checkboxGroup.addValueChangeListener(event -> {
		     if (event.getValue().size() == items.size()) {
		         checkbox.setValue(true);
		         checkbox.setIndeterminate(false);
		     } else if (event.getValue().size() == 0) {
		         checkbox.setValue(false);
		         checkbox.setIndeterminate(false);
		     } else
		         checkbox.setIndeterminate(true);

		 });
		 checkbox.addValueChangeListener(event -> {

		     if (checkbox.getValue()) {
		         checkboxGroup.setValue(items);
		     } else {
		         checkboxGroup.deselectAll();
		     }
		 });
		 checkboxGroup.setValue(Collections.singleton("Option one"));		 

		 // Button Show Code Component Text
		 Div value = new Div();
		 value.setText("Select a value");
		 checkboxGroup.addValueChangeListener(event -> {
		     if (event.getValue() == null) {
		         value.setText("No option selected");
		     } else {
		         value.setText("Selected: " + event.getValue());
		     }
		 });		 
	 
	     // Code Layout
		 VerticalLayout codeLayout = new VerticalLayout(); 
		 codeLayout.setVisible(false);
		 codeLayout.getElement().getStyle().set("background-color", "white");
		 
		 codeLayout.add(javaCode);
		 
		 // Button Show Code Component Text		 
		 Button btnShowCode = new Button("Show Code", new Icon(VaadinIcon.ARROW_DOWN));
		 btnShowCode.getElement().getStyle().set("margin-left", "auto");
		 btnShowCode.addClickListener(event -> {
			 if (codeLayout.isVisible()) {
				 codeLayout.setVisible(false);
				 btnShowCode.setIcon(new Icon(VaadinIcon.ARROW_DOWN));
			 }
			 else {
				 codeLayout.setVisible(true);
				 btnShowCode.setIcon(new Icon(VaadinIcon.ARROW_UP));
			 }
	     });
		 
		 // Main Layout
		 VerticalLayout mainLayout = new VerticalLayout();
		 
		 mainLayout.add(new H1("Indeterminate checkbox"));		 
		 mainLayout.add(checkboxGroup, value);
		 mainLayout.add(btnShowCode);		 
		 mainLayout.add(codeLayout);
		 mainLayout.add(new Hr());
		 
		 return mainLayout;
	 }
	 
	 private Component getHelpTestComponent() {
		 // Code Component Text
		 PrismHighlighter javaCode = new PrismHighlighter(
				    "CheckboxGroup<Department> checkboxGroup = new CheckboxGroup<>();\n" +	                
				    "checkboxGroup.setLabel(\"Departments\");\n" +
				    "List<Department> departmentList = getDepartments();\n" +
				    "checkboxGroup.setItems(departmentList);\n" +
				    "checkboxGroup.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);\n" +
				    "checkboxGroup.setHelperText(\"Choose your current departments\");\n" +
				    "" +
				    "CheckboxGroup<String> checkboxGroupHelperComponent = new CheckboxGroup<>();\n" +
				    "checkboxGroupHelperComponent.setLabel(\"Options\");\n" +
				    "checkboxGroupHelperComponent.setItems(\"Option one\", \"Option two\", \"Option three\");\n" +
				    "checkboxGroupHelperComponent.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);\n" +
				    "checkboxGroupHelperComponent.setHelperComponent(new Span(\"Choose any options\"));\n" +				    
	                "add(checkboxGroup, checkboxGroupHelperComponent);",	                
	                Language.java);		 
		 
		 // Code Components Test
		 CheckboxGroup<Department> checkboxGroup = new CheckboxGroup<>();
		 checkboxGroup.setLabel("Departments");
		 List<Department> departmentList =  Department.getDepartments();
		 checkboxGroup.setItems(departmentList);
		 checkboxGroup.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);
		 checkboxGroup.setHelperText("Choose your current departments");

		 CheckboxGroup<String> checkboxGroupHelperComponent = new CheckboxGroup<>();
		 checkboxGroupHelperComponent.setLabel("Options");
		 checkboxGroupHelperComponent
		       .setItems("Option one", "Option two", "Option three");
		 checkboxGroupHelperComponent
		       .addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);
		 checkboxGroupHelperComponent
		       .setHelperComponent(new Span("Choose any options"));
		 
		 // Button Show Code Component Text
		 Div value = new Div();
		 value.setText("Select a value");
		 checkboxGroup.addValueChangeListener(event -> {
		     if (event.getValue() == null) {
		         value.setText("No option selected");
		     } else {
		         value.setText("Selected: " + event.getValue());
		     }
		 });
	 
	     // Code Layout
		 VerticalLayout codeLayout = new VerticalLayout(); 
		 codeLayout.setVisible(false);
		 codeLayout.getElement().getStyle().set("background-color", "white");
		 
		 codeLayout.add(javaCode);
		 
		 // Button Show Code Component Text
		 Button btnShowCode = new Button("Show Code", new Icon(VaadinIcon.ARROW_DOWN));
		 btnShowCode.getElement().getStyle().set("margin-left", "auto");
		 btnShowCode.addClickListener(event -> {
			 if (codeLayout.isVisible()) {
				 codeLayout.setVisible(false);
				 btnShowCode.setIcon(new Icon(VaadinIcon.ARROW_DOWN));
			 }
			 else {
				 codeLayout.setVisible(true);
				 btnShowCode.setIcon(new Icon(VaadinIcon.ARROW_UP));
			 }
	     });
		 
		 // Main Layout
		 VerticalLayout mainLayout = new VerticalLayout();
		 
		 mainLayout.add(new H1("Helper text and component"));		 
		 mainLayout.add(checkboxGroup, checkboxGroupHelperComponent);
		 mainLayout.add(btnShowCode);		 
		 mainLayout.add(codeLayout);
		 mainLayout.add(new Hr());
		 
		 return mainLayout;
	 }	 
}

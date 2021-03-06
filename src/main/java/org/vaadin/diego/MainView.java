package org.vaadin.diego;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.Route;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The main view contains a button and a template element.
 */
@HtmlImport("styles/shared-styles.html")
@Route("")
public class MainView extends VerticalLayout {


    public MainView() {
        setSizeFull();

        ComboBox<String> comboBox = new ComboBox<>();

        List<String> names = Stream.of("123456789 123456789 123456789 123456789","abcdefghijk","123456789").collect(Collectors.toList());


        comboBox.setRenderer(new ComponentRenderer<>(item -> {
            VerticalLayout container = new VerticalLayout();

            H1 h = new H1(item);

            container.add(h);

            return container;
        }));

        comboBox.setItems( names );

        add(comboBox );
    }
}

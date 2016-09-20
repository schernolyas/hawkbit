/**
 * Copyright (c) 2015 Bosch Software Innovations GmbH and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.hawkbit.ui.customrenderers.client.renderers;

import java.util.Map;

import com.google.common.collect.Maps;
import com.google.gwt.core.client.GWT;
import com.vaadin.client.renderers.WidgetRenderer;
import com.vaadin.client.ui.VLabel;
import com.vaadin.client.widget.grid.RendererCellReference;

/**
 * 
 * Renders label with provided value and style.
 *
 */
public class HtmlLabelRenderer extends WidgetRenderer<String, VLabel> {

    @Override
    public VLabel createWidget() {
        return GWT.create(VLabel.class);
    }

    @Override
    public void render(final RendererCellReference cell, final String input, final VLabel label) {
        final Map<String, String> map = formatInput(input);
        final String value = map.containsKey("value") ? map.get("value") : null;
        final String style = map.containsKey("style") ? map.get("style") : null;
        final String id = map.containsKey("id") ? map.get("id") : null;

        if (value != null) {
            label.setHTML("<span>&#x" + Integer.toHexString(Integer.parseInt(value)) + ";</span>");
        } else {
            label.setHTML("<span></span>");
        }
        applyStyle(label, style);
        label.getElement().setId(id);
    }

    private void applyStyle(final VLabel label, final String style) {
        label.setStyleName(VLabel.CLASSNAME);
        label.addStyleName(getStyle("small"));
        label.addStyleName(getStyle("font-icon"));
        if (style != null) {
            label.addStyleName(getStyle(style));
        }
    }

    private String getStyle(final String style) {
        return new StringBuilder(style).append(" ").append(VLabel.CLASSNAME).append("-").append(style).toString();
    }

    private Map<String, String> formatInput(final String input) {

        final String[] tempData = input.split(",");
        final Map<String, String> details = Maps.newHashMapWithExpectedSize(tempData.length);
        for (final String statusWithCount : tempData) {
            final String[] statusWithCountList = statusWithCount.split(":");
            details.put(statusWithCountList[0], statusWithCountList[1]);
        }
        return details;
    }
}

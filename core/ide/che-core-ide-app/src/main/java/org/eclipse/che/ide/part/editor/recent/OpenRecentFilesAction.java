/*******************************************************************************
 * Copyright (c) 2012-2016 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
package org.eclipse.che.ide.part.editor.recent;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import org.eclipse.che.api.analytics.client.logger.AnalyticsEventLogger;
import org.eclipse.che.ide.CoreLocalizationConstant;
import org.eclipse.che.ide.api.action.AbstractPerspectiveAction;
import org.eclipse.che.ide.api.action.ActionEvent;

import javax.validation.constraints.NotNull;

import static java.util.Collections.singletonList;
import static org.eclipse.che.ide.workspace.perspectives.project.ProjectPerspective.PROJECT_PERSPECTIVE_ID;

/**
 * Action shows dialog with recently opened files.
 *
 * @author Vlad Zhukovskiy
 */
@Singleton
public class OpenRecentFilesAction extends AbstractPerspectiveAction {

    private final RecentFileList       recentFileList;
    private final AnalyticsEventLogger eventLogger;

    @Inject
    public OpenRecentFilesAction(RecentFileList recentFileList,
                                 AnalyticsEventLogger eventLogger,
                                 CoreLocalizationConstant locale) {
        super(singletonList(PROJECT_PERSPECTIVE_ID), locale.openRecentFileTitle(), locale.openRecentFileDescription(), null, null);
        this.recentFileList = recentFileList;
        this.eventLogger = eventLogger;
    }

    /** {@inheritDoc} */
    @Override
    public void updateInPerspective(@NotNull ActionEvent event) {
        event.getPresentation().setEnabledAndVisible(!recentFileList.isEmpty());
    }

    /** {@inheritDoc} */
    @Override
    public void actionPerformed(ActionEvent e) {
        eventLogger.log(this);
        recentFileList.getRecentViewDialog().show();
    }
}

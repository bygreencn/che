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
package org.eclipse.che.ide.projectimport.wizard;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;

import org.eclipse.che.api.workspace.shared.dto.ProjectConfigDto;
import org.eclipse.che.ide.api.wizard.AbstractWizard;

import javax.validation.constraints.NotNull;

/**
 * Project import wizard used for importing a project.
 *
 * @author Artem Zatsarynnyi
 */
public class ImportWizard extends AbstractWizard<ProjectConfigDto> {

    private final ProjectImporter projectImporter;

    @Inject
    public ImportWizard(@Assisted ProjectConfigDto projectConfig, ProjectImporter projectImporter) {
        super(projectConfig);

        this.projectImporter = projectImporter;
    }

    /** {@inheritDoc} */
    @Override
    public void complete(@NotNull CompleteCallback callback) {
        projectImporter.checkFolderExistenceAndImport(callback, dataObject);
    }
}

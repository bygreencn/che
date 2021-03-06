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
package org.eclipse.che.api.analytics.shared.dto;

import org.eclipse.che.dto.shared.DTO;

import java.lang.String;import java.util.Map;

/**
 * @author Anatoliy Bazko
 */
@DTO
public interface EventParameters {
    Map<String, String> getParams();

    void setParams(Map<String, String> params);

    EventParameters withParams(Map<String, String> params);
}
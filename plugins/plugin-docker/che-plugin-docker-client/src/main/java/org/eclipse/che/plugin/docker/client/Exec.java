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
package org.eclipse.che.plugin.docker.client;

import java.util.Arrays;

/**
 * @author andrew00x
 */
public class Exec {
    private final String[] command;
    private final String   id;

    Exec(String[] command, String id) {
        this.command = command;
        this.id = id;
    }

    public String[] getCommand() {
        return command;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Exec{" +
               "command=" + Arrays.toString(command) +
               ", id='" + id + '\'' +
               '}';
    }
}

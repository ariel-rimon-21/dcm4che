/* ***** BEGIN LICENSE BLOCK *****
 * Version: MPL 1.1/GPL 2.0/LGPL 2.1
 *
 * The contents of this file are subject to the Mozilla Public License Version
 * 1.1 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the
 * License.
 *
 * The Original Code is part of dcm4che, an implementation of DICOM(TM) in
 * Java(TM), hosted at https://github.com/dcm4che.
 *
 * The Initial Developer of the Original Code is
 * Agfa Healthcare.
 * Portions created by the Initial Developer are Copyright (C) 2020
 * the Initial Developer. All Rights Reserved.
 *
 * Contributor(s):
 * See @authors listed below
 *
 * Alternatively, the contents of this file may be used under the terms of
 * either the GNU General Public License Version 2 or later (the "GPL"), or
 * the GNU Lesser General Public License Version 2.1 or later (the "LGPL"),
 * in which case the provisions of the GPL or the LGPL are applicable instead
 * of those above. If you wish to allow use of your version of this file only
 * under the terms of either the GPL or the LGPL, and not to allow others to
 * use your version of this file under the terms of the MPL, indicate your
 * decision by deleting the provisions above and replace them with the notice
 * and other provisions required by the GPL or the LGPL. If you do not delete
 * the provisions above, a recipient may use your version of this file under
 * the terms of any one of the MPL, the GPL or the LGPL.
 *
 * ***** END LICENSE BLOCK ***** */

package org.dcm4che3.conf.core.api;

import org.dcm4che3.conf.core.api.ConfigurableProperty;
import org.junit.Assert;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.fail;

/**
 * @author Stephen Frederick <stephen.frederick@agfa.com>
 */
public class InternalConfigChangeEventTest {

    @Test
    public void testDefaultConstructor() {
        Assert.assertTrue(new InternalConfigChangeEvent().getChangedPaths().isEmpty());
    }

    @Test
    public void testConstructorWithExpectedPaths() {
        List<String> expectedChangedPaths = new ArrayList<>();
        expectedChangedPaths.add("path1");
        expectedChangedPaths.add("path2");
        List<String> argChangedPaths = new ArrayList<>();
        argChangedPaths.add("path1");
        argChangedPaths.add("path2");
        List<String> actualChangedPaths = new InternalConfigChangeEvent(argChangedPaths).getChangedPaths();
        Assert.assertEquals(2, actualChangedPaths.size());
        Assert.assertEquals(expectedChangedPaths.get(0), actualChangedPaths.get(0));
        Assert.assertEquals(expectedChangedPaths.get(1), actualChangedPaths.get(1));
    }

}
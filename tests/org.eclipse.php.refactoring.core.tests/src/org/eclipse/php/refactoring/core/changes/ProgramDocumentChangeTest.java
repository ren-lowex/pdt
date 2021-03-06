/*******************************************************************************
 * Copyright (c) 2005, 2015 Zend Technologies and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Zend Technologies - initial API and implementation
 *******************************************************************************/
package org.eclipse.php.refactoring.core.changes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.php.core.tests.TestUtils;
import org.eclipse.php.internal.core.ast.nodes.Program;
import org.eclipse.php.refactoring.core.test.AbstractRefactoringTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProgramDocumentChangeTest extends AbstractRefactoringTest {

	private IProject project1;
	private IFile file;

	@Before
	public void setUp() throws Exception {
		project1 = TestUtils.createProject("project1");
		IFolder folder = TestUtils.createFolder(project1, "src");
		file = TestUtils.createFile(folder, "ProgramDocument.php",
				"<?php class Item { public static function foo(){} } class ItemEx extends Item{public static function foo(){}} ItemEx::foo();?>");
		folder.getFile("ProgramDocument.php");

		TestUtils.waitForIndexer();
	}

	@After
	public void tearDown() throws Exception {
		project1.delete(IResource.FORCE, new NullProgressMonitor());
	}

	@Test
	public void testGetProgram() throws Exception {
		Program program = createProgram(file);

		assertNotNull(program);

		ProgramDocumentChange change = new ProgramDocumentChange("TestProgram", new DummyDocument(), program);
		assertEquals(program, change.getProgram());

		assertEquals(program, change.getAdapter(Program.class));
	}
}

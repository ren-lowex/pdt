package org.eclipse.php.internal.core.typeinference.goals;

import org.eclipse.dltk.ast.ASTNode;
import org.eclipse.dltk.ti.IContext;
import org.eclipse.dltk.ti.goals.AbstractGoal;

public class VariableDeclarationGoal extends AbstractGoal {

	private ASTNode declaration;

	public VariableDeclarationGoal(IContext context, ASTNode declaration) {
		super(context);
		this.declaration = declaration;
	}

	public ASTNode getDeclaration() {
		return declaration;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((declaration == null) ? 0 : declaration.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		VariableDeclarationGoal other = (VariableDeclarationGoal) obj;
		if (declaration == null) {
			if (other.declaration != null) {
				return false;
			}
		} else if (!declaration.equals(other.declaration)) {
			return false;
		}
		return true;
	}
}
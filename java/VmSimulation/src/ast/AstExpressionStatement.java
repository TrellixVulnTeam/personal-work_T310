package ast;

import token.Token;

public class AstExpressionStatement extends AstNode {
    private Token token;
    private AstNode expression;

    public AstExpressionStatement() {
        type = AstNodeType.EXPRESSION_STATEMENT;
    }

    public AstExpressionStatement(Token token) {
        type = AstNodeType.EXPRESSION_STATEMENT;
        this.token = token;
    }

    //@Override
    //public String tokenLiteral() {
    //    return null;
    //}

    @Override
    public String toString() {
        if (expression != null) return "[AstExpressionStatement] <" + expression + ">";
        return null;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public AstNode getExpression() {
        return expression;
    }

    public void setExpression(AstNode expression) {
        this.expression = expression;
    }

}

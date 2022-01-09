package APIDTO;

import java.util.ArrayList;

public class KeywordSearchResultsDTO {
	  public Object cursorToken;
	    public int originalStatementCount;
	    public ArrayList<SearchKeywordStatementDTO> statements;
	    
		public Object getCursorToken() {
			return cursorToken;
		}
		public void setCursorToken(Object cursorToken) {
			this.cursorToken = cursorToken;
		}
		public int getOriginalStatementCount() {
			return originalStatementCount;
		}
		public void setOriginalStatementCount(int originalStatementCount) {
			this.originalStatementCount = originalStatementCount;
		}
		public ArrayList<SearchKeywordStatementDTO> getStatements() {
			return statements;
		}
		public void setStatements(ArrayList<SearchKeywordStatementDTO> statements) {
			this.statements = statements;
		}
		
	}



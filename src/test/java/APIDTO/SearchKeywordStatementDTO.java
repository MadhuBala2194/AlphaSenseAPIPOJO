package APIDTO;

import java.util.ArrayList;

public class SearchKeywordStatementDTO {
	
	    public String accessionNumber;
	    public ArrayList<String> collapsedStatements;
	    public String content;
	    public boolean context;
	    public int page;
	    public boolean recurring;
	    public int snippetCount;
	    public int snippetOffset;
	    public String statementId;
	    public int statementIndex;
	    public int statementIndexOffset;
	    
		public String getAccessionNumber() {
			return accessionNumber;
		}
		public void setAccessionNumber(String accessionNumber) {
			this.accessionNumber = accessionNumber;
		}
		public ArrayList<String> getCollapsedStatements() {
			return collapsedStatements;
		}
		public void setCollapsedStatements(ArrayList<String> collapsedStatements) {
			this.collapsedStatements = collapsedStatements;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public boolean isContext() {
			return context;
		}
		public void setContext(boolean context) {
			this.context = context;
		}
		public int getPage() {
			return page;
		}
		public void setPage(int page) {
			this.page = page;
		}
		public boolean isRecurring() {
			return recurring;
		}
		public void setRecurring(boolean recurring) {
			this.recurring = recurring;
		}
		public int getSnippetCount() {
			return snippetCount;
		}
		public void setSnippetCount(int snippetCount) {
			this.snippetCount = snippetCount;
		}
		public int getSnippetOffset() {
			return snippetOffset;
		}
		public void setSnippetOffset(int snippetOffset) {
			this.snippetOffset = snippetOffset;
		}
		public String getStatementId() {
			return statementId;
		}
		public void setStatementId(String statementId) {
			this.statementId = statementId;
		}
		public int getStatementIndex() {
			return statementIndex;
		}
		public void setStatementIndex(int statementIndex) {
			this.statementIndex = statementIndex;
		}
		public int getStatementIndexOffset() {
			return statementIndexOffset;
		}
		public void setStatementIndexOffset(int statementIndexOffset) {
			this.statementIndexOffset = statementIndexOffset;
		}
	}

	
	  
	




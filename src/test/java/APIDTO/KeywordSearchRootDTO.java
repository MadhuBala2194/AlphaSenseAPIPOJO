package APIDTO;

import java.util.ArrayList;

public class KeywordSearchRootDTO {

    public ArrayList<Object> topics;
    public KeywordSearchResultsDTO keywordSearchResultsDTO;
    
	public ArrayList<Object> getTopics() {
		return topics;
	}
	public void setTopics(ArrayList<Object> topics) {
		this.topics = topics;
	}
	public KeywordSearchResultsDTO getSearchResults() {
		return keywordSearchResultsDTO;
	}
	public void setSearchResults(KeywordSearchResultsDTO searchResults) {
		this.keywordSearchResultsDTO = searchResults;
	}
}


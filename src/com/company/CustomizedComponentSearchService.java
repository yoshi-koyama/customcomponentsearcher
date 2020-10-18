package com.company;

import java.io.IOException;
import java.util.List;

public interface CustomizedComponentSearchService {

    List<SearchResult> execute(String tenatName) throws Exception;
}

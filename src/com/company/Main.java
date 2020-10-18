package com.company;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {

        CustomizedComponentSearchService searchService = new CustomizedComponentSearchServiceImpl();
        List<SearchResult> searchResults = searchService.execute("docommon");
        searchResults.forEach(searchResult -> System.out.println(searchResult.toString()));

//        JOptionPane.showMessageDialog(null, "ファイルが出力されました。", "SUCCESS",
//                JOptionPane.PLAIN_MESSAGE);
    }
}
